package com.wjl.teacher_management.controller.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.common.constant.PaginationConstant;
import com.wjl.teacher_management.common.util.ResponseResult;
import com.wjl.teacher_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/2 21:11
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Controller
@RequestMapping("/manager")
public class TeachersController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public String findAll(Model model, Integer pageNum){
        if(ObjectUtils.isEmpty(pageNum)||pageNum<1){
            pageNum= PaginationConstant.PAGE_NUM;
        }
        PageHelper.startPage(pageNum, 8);

        List<Teacher> teachers = teacherService.findAll();
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        model.addAttribute("pageInfo",pageInfo);

        return "manager/teacher_info";
    }

    @GetMapping("/teacher")
    public String toTeacher(){

        return "manager/update_teacher";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(){

        return "update";
    }


    @GetMapping("/edit/{id}")
    public String toEdit(Model model,@PathVariable("id") Integer id){

        Teacher teacher= teacherService.findById(id);
        model.addAttribute("teacher",teacher);
        return "update";
    }

    @PutMapping("/teacher")
    public String modifyTeacher(Teacher teacher){
        teacherService.update(teacher);

        return "redirect:/manager/teachers";
    }

    @GetMapping("/add")
    public String testAdd(Model model){
        teacherService.insert();
        return "redirect:/teacher_info";
    }

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable("id") int id, Model model){

        return "redirect:/teacher_info";
    }
}
