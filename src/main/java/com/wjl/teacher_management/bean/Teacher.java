package com.wjl.teacher_management.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: wugege
 * @Date: 2020/3/2 21:33
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class Teacher {
    private Integer id ;
    private String name ;
    private int sex ;
    private Date birth ;
    private String dept ;
    private String job ;
    private Date entTime ;
    private String education ;
    private Skill skill_id ;
    private int uid;

    public Teacher(String name, int sex, Date birth, String dept, String job, Date entTime, String education) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.dept = dept;
        this.job = job;
        this.entTime = entTime;
        this.education = education;
    }
}
