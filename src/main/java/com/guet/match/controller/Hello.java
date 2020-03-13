package com.guet.match.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sefer
 * @Date: 2020/3/13
 * @Description:
 */

@RestController
public class Hello {
    @RequestMapping("/")
    public String hello(){
        return "222";
    }
}
