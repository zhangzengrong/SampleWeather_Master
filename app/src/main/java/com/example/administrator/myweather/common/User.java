package com.example.administrator.myweather.common;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 作者：Rookie
 * 邮箱：1939428911.com
 * 注释：用户表
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    public String userId,name,studentNum,mobile="138001380000",age="21",sex="男",major="软件工程",headUrl="https://ps.ssl.qhimg.com/t015532674953445652.jpg",pwd;
    @Generated(hash = 1739226374)
    public User(Long id, String userId, String name, String studentNum,
                String mobile, String age, String sex, String major, String headUrl,
                String pwd) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.studentNum = studentNum;
        this.mobile = mobile;
        this.age = age;
        this.sex = sex;
        this.major = major;
        this.headUrl = headUrl;
        this.pwd = pwd;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStudentNum() {
        return this.studentNum;
    }
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getMajor() {
        return this.major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getHeadUrl() {
        return this.headUrl;
    }
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
