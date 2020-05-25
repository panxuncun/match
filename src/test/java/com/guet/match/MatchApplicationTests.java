package com.guet.match;

import com.guet.match.controller.TopicController;
import com.guet.match.mapper.CmsContestGroupMapper;
import com.guet.match.mapper.CmsContestMapper;
import com.guet.match.service.AuthService;
import com.guet.match.service.TopicService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MatchApplicationTests {

    Logger logger = LoggerFactory.getLogger(MatchApplicationTests.class);

    @Autowired
    private CmsContestMapper contestMapper;

    @Autowired
    private AuthService authService;

    @Autowired
    private TopicController topicController;
    @Autowired
    private TopicService topicService;

    @Autowired
    private CmsContestGroupMapper groupMapper;

    @Test
    void contextLoads() {
        logger.info("=====getContestDtoByid");
        contestMapper.getContestDtoByid(68L);
        //System.out.println(topicService.deleteTopicOrComment(266L));
    }

    @Test
    void contextLoads1() {
        logger.info("=====get group list");
        logger.info("=====size"+groupMapper.getGroupListByContestId(68L).size());
        //System.out.println(topicService.deleteTopicOrComment(266L));
    }


    public static void main(String[] args) {
        //get 请求
        //来源https://my.oschina.net/u/3177357/blog/2239749
        //RestTemplate restTemplate = new RestTemplate();
        //String url = "https://challage.cn/guet/api/news/detail/2";
        //用字符串接收结果
        //String res = restTemplate.getForObject(url,String.class);
        //System.out.println(res);
        //用map接收结果
        //Map map = restTemplate.getForObject(url,Map.class);
        //System.out.println("=======");
        //System.out.println(map.get("newsTitle"));

        //post请求，data是要发送的数据
        //Map data = new HashMap();
        //res = restTemplate.postForObject(url,data,String.class);
        //System.out.println("post返回结果："+res);

        char pre = 65;

        int count = 100;
        int len = String.valueOf(count).length();
        System.out.println(len);

        for (int i = 1; i <= count; i++) {
            String str = String.format("%0"+len+"d", i);
            System.out.println(pre+str);
        }


    }



}
