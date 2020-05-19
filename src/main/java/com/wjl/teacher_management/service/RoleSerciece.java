package com.wjl.teacher_management.service;

import com.wjl.teacher_management.service.vo.RoleVo;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/5/14 11:49
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public interface RoleSerciece {

    int addRole(int mid);

    int remRole(int mid);

    List<RoleVo> selectAll();
}
