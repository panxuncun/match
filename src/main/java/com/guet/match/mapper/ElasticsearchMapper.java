package com.guet.match.mapper;

import com.guet.match.model.CmsContest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Auther: sefer
 * @Date: 2020/3/28
 * @Description: 继承 spring jpa 的接口，获得查询方法
 */
public interface ElasticsearchMapper extends ElasticsearchRepository<CmsContest, Long> {
    List<CmsContest> findByName(String name);
    List<CmsContest> findByType(String type);
    List<CmsContest> findByDetailsContains(String details);

    //todo set status为审核通过的
    List<CmsContest> findByDetailsContainsOrNameContains(String keyword1,String keyword2);

    //like最为智能
    List<CmsContest> findByDetailsLikeOrNameLike(String keyword1,String keyword2);
    //注意方法名，不要把find携程fin
    List<CmsContest> findByNameOrDetails(String name,String details);
}
