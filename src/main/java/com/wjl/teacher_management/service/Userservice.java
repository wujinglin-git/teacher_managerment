package com.wjl.teacher_management.service;

import com.wjl.teacher_management.bean.SysUser;
import com.wjl.teacher_management.bean.User;
import com.wjl.teacher_management.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wugege
 * @Date: 2020/5/15 17:00
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Service
public class Userservice {

    @Autowired
    UserMapper userMapper;

    public int addUser(SysUser user){
        return userMapper.addUser(user);
    }

    public SysUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public int addRole(Integer uid) {
        return userMapper.addRole(uid);
    }
}
