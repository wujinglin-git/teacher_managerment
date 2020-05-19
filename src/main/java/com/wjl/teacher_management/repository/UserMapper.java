package com.wjl.teacher_management.repository;

import com.wjl.teacher_management.bean.SysUser;
import com.wjl.teacher_management.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: wugege
 * @Date: 2020/2/25 18:58
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Mapper
public interface UserMapper {

    SysUser findByUsername(@Param("username") String username);

    int addUser(SysUser user);

    int addRole(Integer uid);
}
