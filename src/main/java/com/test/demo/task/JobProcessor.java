package com.test.demo.task;

import com.test.demo.pojo.JobInfo;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component
public class JobProcessor implements PageProcessor {
    //前程无忧网站的职位列表地址
    private String url="https://search.51job.com/list/170200,000000,0000,00,9,99,%2B,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
    @Override
    public void process(Page page) {
        //解析页面，获取招聘信息详情的url地址
        List<Selectable> list = page.getHtml().css("div#resultList div.el").nodes();
        //判断集合是否为空
        if(list.size()==0){
            //如果为空，表示这是招聘详情页，解析页面，获取招聘详情信息，保存数据
            this.saveJobInfo(page);
        }else {
            //如果不为空，表示这是列表页，解析出详情页的url地址，放到任务队列中
            for(Selectable selectable:list){
                String jobInfoUrl = selectable.links().toString();
                //把获取到的详情页的url地址放到任务队列中
                page.addTargetRequest(jobInfoUrl);
            }
            //获取下一页按钮的url
            String bkUrl=page.getHtml().css("div.p_in li.bk").nodes().get(1).links().toString();//get(1)拿到第二个
            //把下一页的url放到任务队列中
            page.addTargetRequest(bkUrl);
        }
    }

    //解析页面，获取招聘详情信息，保存数据
    private void saveJobInfo(Page page) {
        //创建招聘详情对象
        JobInfo jobInfo=new JobInfo();
        //拿到解析的页面
        Html html = page.getHtml();
        //获取数据，封装到对象中
        //两种获取的方法，一种是直接html.css，另一种是使用Jsoup.parse解析html字符串
        jobInfo.setCompanyName(html.css("div.cn p.cname a","text").toString());
        String addrStr = Jsoup.parse(html.css("div.cn p.msg").toString()).text();
        String addr=addrStr.substring(0,addrStr.indexOf("|"));

        jobInfo.setCompanyAddr(addr);
        jobInfo.setCompanyInfo(html.css("div.tmsg","text").toString());
        jobInfo.setUrl(page.getUrl().toString());
        jobInfo.setJobName(Jsoup.parse(html.css("div.cn h1","title").toString()).text());
        jobInfo.setJobAddr(addr);
        jobInfo.setSalary(Jsoup.parse(html.css("div.cn strong").toString()).text());


        //把结果保存起来
        page.putField("jobInfo",jobInfo);
    }

    private Site site=Site.me()
            .setCharset("gbk")//设置编码(页面是什么编码就设置成什么编码格式的)
            .setTimeOut(10*1000)//设置超时时间
            .setRetrySleepTime(3000)//设置重试的间隔时间
            .setRetryTimes(3);//设置重试的次数
    @Override
    public Site getSite() {
        return site;
    }
    //这里注入SaveData
    @Autowired
    private SaveData saveData;
    //initialDelay当任务启动后，等多久执行方法
    //fixedDelay每个多久执行方法
    @Scheduled(initialDelay = 1000,fixedDelay = 100*1000)
    public void process(){
        Spider.create(new JobProcessor())
                .addUrl(url)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(5)
                .addPipeline(this.saveData)//指定把爬取的数据保存到SaveData类的ResultItems中
                .run();
    }
}