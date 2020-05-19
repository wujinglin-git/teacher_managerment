package com.wjl.teacher_management.bean;

import lombok.Data;

import java.sql.Date;

/**
 * @Author: wugege
 * @Date: 2020/3/2 21:39
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Data
public class Skill {
    private Integer id;
    private String name;
    private double price;
    private int period;
    private String descrip;
    private int  repeat;

}
