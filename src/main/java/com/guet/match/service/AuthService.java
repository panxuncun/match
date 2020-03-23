package com.guet.match.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/3/16
 * @Description: 授权模块
 */
@Service
public class AuthService {
    private String APPID = "wx84487af617e5f965";
    private String APPSECRET = "a5bdd00685bec189d9002363a0ee4ef0";


    //给小程序授权
    public Map getAuth(String code) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String res = restTemplate.getForObject(url, String.class);
        try {
            Map<String ,String > map = objectMapper.readValue(res, Map.class);
            if (map.containsKey("errcode")){
                return null;
            }
            map.put("token", "abcde");//todo 实现token算法,利用session_key配合自己的
            return map;
        } catch (Exception e) {
            return null;
        }
    }


    //微信服务器的 getAccessToken
    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
        String res = restTemplate.getForObject(url, String.class);
        try {
            Map<String ,String > map = objectMapper.readValue(res, Map.class);
            return map.get("access_token");//获取失败时为null
        } catch (Exception e) {
            return null;
        }

    }
}
