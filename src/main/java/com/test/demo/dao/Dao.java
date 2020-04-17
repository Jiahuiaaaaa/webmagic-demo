package com.test.demo.dao;

import com.test.demo.pojo.JobInfo;
import org.apache.ibatis.annotations.Insert;

public interface Dao {
   @Insert(value = "insert into jobinfo(companyName,companyAddr,companyInfo,jobName,jobAddr,salary,url) values(#{companyName},#{companyAddr},#{companyInfo},#{jobName},#{jobAddr},#{salary},#{url});")
   int saveJobInfo(JobInfo jobInfo);

}
