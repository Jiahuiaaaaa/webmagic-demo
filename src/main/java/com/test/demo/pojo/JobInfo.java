package com.test.demo.pojo;

public class JobInfo {
    private Integer id;
    private String companyName;
    private String companyAddr;
    private String companyInfo;
    private String jobName;
    private String jobAddr;
    private String salary;
    private String time;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JobInfo() {
    }

    public JobInfo(Integer id, String companyName, String companyAddr, String companyInfo, String jobName, String jobAddr, String salary, String time) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddr = companyAddr;
        this.companyInfo = companyInfo;
        this.jobName = jobName;
        this.jobAddr = jobAddr;
        this.salary = salary;
        this.time = time;
    }

    public JobInfo(Integer id, String companyName, String companyAddr, String companyInfo, String jobName, String jobAddr, String salary, String time, String url) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddr = companyAddr;
        this.companyInfo = companyInfo;
        this.jobName = jobName;
        this.jobAddr = jobAddr;
        this.salary = salary;
        this.time = time;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobAddr() {
        return jobAddr;
    }

    public void setJobAddr(String jobAddr) {
        this.jobAddr = jobAddr;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}