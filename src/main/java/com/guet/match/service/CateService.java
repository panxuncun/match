package com.guet.match.service;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.CateDTO;
import com.guet.match.mapper.CmsContestCateMapper;
import com.guet.match.model.CmsContestCate;
import com.guet.match.model.CmsContestCateExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/4/22
 * @Description: 赛事种类服务
 */
@Service
public class CateService {
    @Autowired
    private CmsContestCateMapper cateMapper;

    //添加种类
    public CommonResult addCate(CmsContestCate cate) {
        cate.setId(null);
        return cateMapper.insertSelective(cate) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    //获取所有种类带子分类
    public CommonResult getListWithChildren(){
        //所有一级分类
        CmsContestCateExample example = new CmsContestCateExample();
        example.setOrderByClause("sort asc");
         example.createCriteria().andParentIdEqualTo(0L);
        List<CmsContestCate> cateList = cateMapper.selectByExample(example);

        //填充子分类
        List<CateDTO> dtoList = new ArrayList<>();
        cateList.stream().forEach(cate->{
            CateDTO dto = new CateDTO();
            BeanUtils.copyProperties(cate, dto);
            dto.setChildren(getChildren(dto.getId()));
            dtoList.add(dto);
        });

        return CommonResult.success(dtoList);

    }

    public List<CmsContestCate> getChildren(Long parentId) {
        CmsContestCateExample example = new CmsContestCateExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return cateMapper.selectByExample(example);

    }

    //获取所有二级种类,不需要分页
    public CommonResult getList() {
        CmsContestCateExample example = new CmsContestCateExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andParentIdNotEqualTo(0L);
        return CommonResult.success(cateMapper.selectByExample(example));
    }

    //获取所有一级种类
    public CommonResult getParentList() {
        CmsContestCateExample example = new CmsContestCateExample();
        example.setOrderByClause("sort asc");
        example.createCriteria().andParentIdEqualTo(0L);
        return CommonResult.success(cateMapper.selectByExample(example));
    }

    //获取二级种类by 一级种类
    public CommonResult getListByParent(Long parentId) {
        CmsContestCateExample example = new CmsContestCateExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return CommonResult.success(cateMapper.selectByExample(example));
    }

    //更新种类(限制由前端负责)
    public CommonResult updateCate(CmsContestCate cate) {
        return cateMapper.updateByPrimaryKeySelective(cate) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }

    //删除种类
    public CommonResult deleteCate(Long id) {
        CmsContestCate cate = cateMapper.selectByPrimaryKey(id);
        if (cate == null) {
            return CommonResult.failed();
        }
        if (cate.getParentId() == 0L) {
            CmsContestCateExample example = new CmsContestCateExample();
            example.createCriteria().andParentIdEqualTo(id);
            cateMapper.deleteByExample(example);
        }
        return cateMapper.deleteByPrimaryKey(id) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }


}
