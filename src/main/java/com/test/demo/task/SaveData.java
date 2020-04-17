package com.test.demo.task;

import com.test.demo.pojo.JobInfo;
import com.test.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class SaveData implements Pipeline {
    @Autowired
    Service service;
    @Override
    public void process(ResultItems resultItems, Task task) {
        //获取封装好的招聘详情对象
        JobInfo jobInfo=resultItems.get("jobInfo");
        if(jobInfo!=null){
            //保存数据到数据库中
            service.saveJobInfo(jobInfo);
        }
    }
}
