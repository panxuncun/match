package com.guet.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: sefer
 * @Date: 2020/5/26
 * @Description: 打包的前端工程扔到这里
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
