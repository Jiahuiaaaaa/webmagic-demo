package com.test.demo.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class BlogPageProcessor implements PageProcessor {
    private Site site = Site.me();

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {

        Spider.create(new BlogPageProcessor()).addUrl("http://juejin.im/post/5e216eda6fb9a0300e1617eb")
                .addPipeline(new FilePipeline("D:/webmagic"))
                .run();

    }

}
