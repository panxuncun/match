package com.guet.match;

import com.guet.match.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MatchApplicationTests {

    //@Autowired
    //private SmsService smsService;
    @Autowired
    private AuthService authService;


    @Test
    void contextLoads() {
        System.out.println("======");
        authService.getAccessToken();
    }


    public static void main(String[] args) {
        //get 请求
        //来源https://my.oschina.net/u/3177357/blog/2239749
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://challage.cn/guet/api/news/detail/2";
        //用字符串接收结果
        String res = restTemplate.getForObject(url,String.class);
        System.out.println(res);
        //用map接收结果
        Map map = restTemplate.getForObject(url,Map.class);
        System.out.println("=======");
        System.out.println(map.get("newsTitle"));

        //post请求，data是要发送的数据
        Map data = new HashMap();
        res = restTemplate.postForObject(url,data,String.class);
        System.out.println("post返回结果："+res);
    }



}
