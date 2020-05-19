package com.wjl.teacher_management.bean;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/2/27 13:04
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public class SysUser {
    private int id;
    private String username;
    private String password;

    private List<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
