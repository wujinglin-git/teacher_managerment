package com.wjl.teacher_management.repository;

import com.wjl.teacher_management.bean.Role;
import com.wjl.teacher_management.service.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/2/25 21:28
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Mapper
public interface RoleMapper {
    List<Role> getRolesByUserId(@Param("username") String username);

    List<RoleVo> selectAll();

    int addRole(@Param("id") int mid);

    int remRole(@Param("id") int mid);
}
