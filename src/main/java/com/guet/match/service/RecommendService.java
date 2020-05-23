package com.guet.match.service;

import com.guet.match.common.CommonResult;
import com.guet.match.common.ContestStatus;
import com.guet.match.mapper.CmsContestMapper;
import com.guet.match.mapper.CmsRecommendMapper;
import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsContestExample;
import com.guet.match.model.CmsRecommend;
import com.guet.match.model.CmsRecommendExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/5/4
 * @Description: 赛事推荐
 */
@Service
public class RecommendService {

    @Autowired
    private CmsRecommendMapper recommendMapper;

    @Autowired
    private CmsContestMapper contestMapper;

    private int MaxCount = 5;

    //清除残余的无效id，因为回导致查不到，而且还占用了5的空间
    public int cleanRecommend(){
        CmsRecommendExample example = new CmsRecommendExample();
        List<Long> ids = recommendMapper.selectByExample(example).stream().map(item -> item.getContestId()).collect(Collectors.toList());
        for (Long id:ids){
            CmsContest contest= contestMapper.selectByPrimaryKey(id);
            if (contest == null) {
                CmsRecommendExample example1 = new CmsRecommendExample();
                example1.createCriteria().andContestIdEqualTo(id);
                recommendMapper.deleteByExample(example1);
            }
        }
        return 1;
    }

    //添加推荐
    public CommonResult addRecommend(CmsRecommend recommend) {
        //先清除残余的再说
        cleanRecommend();
        //开始添加推荐
        CmsRecommendExample example = new CmsRecommendExample();
        if (recommendMapper.countByExample(example) >= MaxCount) {
            return CommonResult.failed("推荐的赛事已达" + MaxCount + "个的上限，请移除非必要的赛事");
        }
        example.createCriteria().andContestIdEqualTo(recommend.getContestId());
        if (recommendMapper.countByExample(example) > 0) {
            return CommonResult.failed("请勿重复推荐");
        }
        return recommendMapper.insertSelective(recommend) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    //删除推荐
    public CommonResult deleteRecommendByContestId(Long id) {
        CmsRecommendExample example = new CmsRecommendExample();
        example.createCriteria().andContestIdEqualTo(id);

        return recommendMapper.deleteByExample(example) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    //小程序：获取所有推荐（审核通过的）
    public CommonResult list() {
        CmsRecommendExample example = new CmsRecommendExample();
        List<Long> ids = recommendMapper.selectByExample(example).stream().map(item -> item.getContestId()).collect(Collectors.toList());
        if (ids.size() == 0) {
            return CommonResult.success(null);
        }
        CmsContestExample example1 = new CmsContestExample();
        example1.createCriteria().andIdIn(ids).andStatusEqualTo(ContestStatus.PASS.getStatus());
        return CommonResult.success(contestMapper.selectByExample(example1));
    }

    //管理员，获取所有推荐（所有类型）
    public CommonResult listForAdmin() {
        CmsRecommendExample example = new CmsRecommendExample();
        List<Long> ids = recommendMapper.selectByExample(example).stream().map(item -> item.getContestId()).collect(Collectors.toList());
        if (ids.size() == 0) {
            return CommonResult.success(null);
        }
        CmsContestExample example1 = new CmsContestExample();
        example1.createCriteria().andIdIn(ids);
        return CommonResult.success(contestMapper.selectByExample(example1));
    }




}
