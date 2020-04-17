package com.test.demo.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class ProcessDemo1 implements PageProcessor {

    public void process(Page page) {
        System.out.println(page.getHtml().toString()); // 抓取全部内容
    }

    public Site getSite() {
        // setRetryTimes 设置重试次数
        // setSleepTime 设置时间间隔（毫秒） 默认5秒
        return Site.me().setRetryTimes(3).setSleepTime(100);
    }

    public static void main(String[] args) {
        Spider.create(new ProcessDemo1()).addUrl("https://blog.csdn.net/").addPipeline(new FilePipeline("D:/webmagic")).run();
    }

}
