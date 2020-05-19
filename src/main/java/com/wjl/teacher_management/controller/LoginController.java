package com.wjl.teacher_management.controller;

import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.bean.User;
import com.wjl.teacher_management.service.TeacherService;
import com.wjl.teacher_management.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: wugege
 * @Date: 2020/4/16 11:43
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String hello(HttpSession session) {//这边我们,默认是返到templates下的login.html



        return "login";
    }
    @GetMapping("/changePassword")
    public String changePassword( ) {//这边我们,默认是返到templates下的login.html



        return "changePassword";
    }

}
