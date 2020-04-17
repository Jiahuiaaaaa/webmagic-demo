package com.test.demo.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobProcessor implements PageProcessor {
    public void process(Page page) {
        page.putField("author", page.getHtml().css("div.mt>h1").all());
    }
    private Site site = Site.me();
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                //初始访问url地址
//                .addUrl("https://www.jd.com/moreSubject.aspx")
                .addUrl("https://www.baidu.com")
                .run();
    }
}