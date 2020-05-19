package com.wjl.teacher_management.controller;

import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.repository.TeacherMapper;
import com.wjl.teacher_management.service.TeacherService;
import com.wjl.teacher_management.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: wugege
 * @Date: 2020/2/25 15:47
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Controller
public class TestController {



    @Autowired
    TeacherService teacherService;
    @RequestMapping("/")
    public String index(Model model,HttpSession session){
        //从SecurityContextHolder中得到Authentication对象，进而获取权限列表，传到前端
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) auth.getAuthorities();
//        model.addAttribute("authorities", authorityCollection.toString());
//        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        //查出user_id放入session
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Teacher teacher = teacherService.findByUsername(username);
        if (teacher != null){
            session.setAttribute("id",teacher.getId());
            session.setAttribute("name",teacher.getName());
        }else{
            session.setAttribute("name",username);
        }


        return "main";
    }

    @GetMapping("/role")
    public String role(HttpSession session){
        return "/index";

    }

    @GetMapping("/index")
    public String index(HttpSession session){
        return "/index";
    }

}
