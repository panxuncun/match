package com.guet.match.service;

import com.github.pagehelper.PageHelper;
import com.guet.match.mapper.ElasticsearchMapper;
import com.guet.match.mapper.CmsContestMapper;
import com.guet.match.model.CmsContest;
import com.guet.match.model.CmsContestExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/28
 * @Description: 搜索服务
 */
@Service
public class SearchService {
    Logger logger = LoggerFactory.getLogger(SearchService.class);
    @Autowired
    private CmsContestMapper contestMapper;

    @Autowired
    private ElasticsearchMapper elasticsearchMapper;


    public int importAll() {

        //得到全部赛事
        CmsContestExample example = new CmsContestExample();
        example.createCriteria();
        List<CmsContest> list = contestMapper.selectByExampleWithBLOBs(example);
        logger.info("存入{}条记录到elasticsearch", list.size());


        //保存到 es
        elasticsearchMapper.saveAll(list);
        return 1;
    }


    public void delete(Long id) {
        elasticsearchMapper.deleteById(id);
    }


    public CmsContest create(Long id) {
        return contestMapper.selectByPrimaryKey(id);
    }


    public void delete(List<Long> ids) {
        List<CmsContest> esProductList = new ArrayList<>();
        for (Long id : ids) {
            CmsContest esProduct = new CmsContest();
            esProduct.setId(id);
            esProductList.add(esProduct);
        }
        elasticsearchMapper.deleteAll(esProductList);
    }


    public List<CmsContest> search(String param, Integer pageNum, Integer pageSize) {

        String keyword = param.replaceAll(" ", "");

        //优先使用elasticsearch
        List<CmsContest> list = new LinkedList<>();
        PageHelper.startPage(pageNum, pageSize);
        try {
            importAll();
            list = elasticsearchMapper.findByDetailsLikeOrNameLike(keyword, keyword);
            logger.info("   ES搜索->{},得到{}条记录", keyword, list.size());
        } catch (Exception e) {
            logger.error("无法连接es");
        }

        //如果查不到东西，mysql兜底
        if (list == null || list.size() == 0) {
            CmsContestExample example = new CmsContestExample();
            example.createCriteria().andNameLike("%" + keyword + "%");
            list = contestMapper.selectByExample(example);
            logger.info("MySQL搜索->{},得到{}条记录", keyword, list.size());
        }

        //set details为空
        list.stream().forEach(item -> item.setLastCheckNote(null));
        list.stream().forEach(item -> item.setDetails(null));

        return list;
    }
}
