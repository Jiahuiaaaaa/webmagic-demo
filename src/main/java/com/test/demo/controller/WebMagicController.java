package com.test.demo.controller;

import com.test.demo.task.JobProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebMagicController {

    @Autowired
    private JobProcessor jobProcessor;

    @GetMapping("/getJob")
    public  String getJob(){
        jobProcessor.process();
        return  "getJob success!!!";
    }



}
