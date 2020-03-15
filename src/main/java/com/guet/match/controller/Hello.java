package com.guet.match.controller;

import com.guet.match.model.SmsTopic;
import com.guet.match.service.SmsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sefer
 * @Date: 2020/3/13
 * @Description:
 */

@RestController
public class Hello {
    @Autowired
    private SmsService smsService;


    @RequestMapping("/topic")
    public SmsTopic tp(){
        return smsService.getATopic();
    }

    @RequestMapping("/insert")
    public Long insert(@RequestBody SmsTopic smsTopic){
        System.out.println(smsTopic.getText());
        return smsService.insertTopic(smsTopic);
    }
    @RequestMapping("/getTopic/{id}")
    public SmsTopic getTopic(@PathVariable("id") Long id){
        return smsService.getATopicById(id);
    }


}
