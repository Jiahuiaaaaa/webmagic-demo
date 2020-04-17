package com.test.demo.service.impl;

import com.test.demo.dao.Dao;
import com.test.demo.pojo.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.annotation.Annotation;

@Service
public class ServiceImpl  implements com.test.demo.service.Service {

    @Autowired
    private Dao dao;

    @Override
    public int saveJobInfo(JobInfo jobInfo) {
        int i = dao.saveJobInfo(jobInfo);
        return i;
    }


}