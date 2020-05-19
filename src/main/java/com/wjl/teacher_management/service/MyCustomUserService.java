package com.wjl.teacher_management.service;

import com.wjl.teacher_management.bean.Role;
import com.wjl.teacher_management.bean.SysUser;
import com.wjl.teacher_management.repository.RoleMapper;
import com.wjl.teacher_management.repository.UserMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/2/25 15:46
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Service
public class MyCustomUserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyCustomUserService.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userMapper.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<Role> roles = roleMapper.getRolesByUserId(s);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities。
        for(Role role:roles)
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
