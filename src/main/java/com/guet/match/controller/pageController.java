package com.guet.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: sefer
 * @Date: 2020/3/15
 * @Description:
 */

@Controller
public class pageController {
    @RequestMapping("/")
    public String i1(){
        return "index";
    }
}
