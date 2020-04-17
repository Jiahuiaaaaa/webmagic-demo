package com.test.demo.controller;

import com.test.demo.webmagic.BaiduBaikeSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Page;


@RestController
public class BaiduController {

    @Autowired
    private BaiduBaikeSpider baiduBaikeSpider;

    @GetMapping("/getBaike")
    public String getBaike(Page page){
        baiduBaikeSpider.process(page);
        return "Success!";
    }
}
