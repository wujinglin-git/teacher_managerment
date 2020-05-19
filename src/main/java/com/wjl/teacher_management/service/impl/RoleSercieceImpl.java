package com.wjl.teacher_management.service.impl;

import com.wjl.teacher_management.repository.RoleMapper;
import com.wjl.teacher_management.service.RoleSerciece;
import com.wjl.teacher_management.service.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/5/14 13:12
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Service
public class RoleSercieceImpl implements RoleSerciece {

    @Autowired
    RoleMapper roleMapper;


    @Override
    public int addRole(int mid) {
        return roleMapper.addRole(mid);
    }

    @Override
    public int remRole(int mid) {
        return roleMapper.remRole(mid);
    }

    @Override
    public List<RoleVo> selectAll() {

        return roleMapper.selectAll();
    }
}
