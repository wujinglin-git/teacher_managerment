package com.wjl.teacher_management.controller;

import com.wjl.teacher_management.bean.SysUser;
import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.bean.User;
import com.wjl.teacher_management.repository.TeacherMapper;
import com.wjl.teacher_management.service.TeacherService;
import com.wjl.teacher_management.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author: wugege
 * @Date: 2020/5/15 18:02
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    Userservice userservice;

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public String register() {//这边我们,默认是返到templates下的login.html

        return "registerPage";
    }

    @PostMapping("/toRegister")
    public String register(SysUser user, Model model) {//这边我们,默认是返到templates下的login.html

        userservice.addUser(user);
        user = userservice.findByUsername(user.getUsername());
        model.addAttribute("uid",user.getId());

        return "registerPage2";
    }

//    @GetMapping("/toRegister2")
//    public String register666() {//这边我们,默认是返到templates下的login.html
//
//
//
//        return "/registerPage2";
//    }

    @GetMapping("/UpRegister2")
    public String register2(Teacher teacher) {//这边我们,默认是返到templates下的login.html

        teacherService.add(teacher);

        userservice.addRole(teacher.getUid());
        return "redirect:/login";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public String getUser(){
        Teacher teacher = null;
        for (int i = 0; i < 50; i++) {
            teacher = new Teacher("测试"+i,1,new Date(),"教务处","教工",new Date(),"本科");
            teacherMapper.insertTes(teacher);
        }



        return "success";
    }
}
