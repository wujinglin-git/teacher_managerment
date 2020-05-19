package com.wjl.teacher_management.controller.User;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjl.teacher_management.bean.Skill;
import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import com.wjl.teacher_management.common.constant.PaginationConstant;
import com.wjl.teacher_management.common.util.ResponseResult;
import com.wjl.teacher_management.service.SkillService;
import com.wjl.teacher_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/4/27 10:09
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Controller
@RequestMapping("/user")
public class TeacherController {

    @Autowired
    SkillService skillService;

    @Autowired
    TeacherService teacherService;

    @ModelAttribute
    public void getUser(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // 先获取用户名 ，再通过 用户名查出 教师 id
        Teacher teacher = teacherService.findByUsername(username);

        model.addAttribute("teacher",teacher);
    }

    @GetMapping("/teachers")
    public String findOne(Model model, Integer pageNum){


        return "user/teacher";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(){


        return "user/update";
    }
    @PutMapping("/teacher")
    public String modifyTeacher(Teacher teacher){
        teacherService.update(teacher);

        return "redirect:/user/teachers";
    }


    @GetMapping("/skill")
    public String skill(Integer pageNum, Model model,HttpSession session){
        if(ObjectUtils.isEmpty(pageNum)||pageNum<1){
            pageNum= PaginationConstant.PAGE_NUM;
        }
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        List<Skill> skills = skillService.findAll();
        for (int i = 0; i < skills.size(); i++) {
            skills.get(i).setRepeat(teacherService.reqIsExist((int)session.getAttribute("id"),skills.get(i).getId()));
        }

        PageInfo<Skill> pageInfo = new PageInfo<>(skills);

        model.addAttribute("pageInfo",pageInfo);

        return "user/skills";
    }

    @GetMapping("/request")
    @ResponseBody
    public ResponseResult req(Integer tid,Integer sid){
        ResponseResult responseResult = new ResponseResult();
        System.out.println("tid="+tid+",sid="+sid);
        int s= teacherService.req( tid, sid);
        if (s>0) {
            responseResult.setMessage("申请成功");
        }else {
            responseResult.setMessage("申请失败");
        }
        return responseResult;
    }

    @GetMapping("/status")
    public String toSta(HttpSession session,Model model,Integer pageNum){

        if(ObjectUtils.isEmpty(pageNum)||pageNum<1){
            pageNum= PaginationConstant.PAGE_NUM;
        }
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        int id = (int)session.getAttribute("id");
        List<TeacherSkill> teacherSkill=teacherService.status(id);
        PageInfo<TeacherSkill> pageInfo = new PageInfo<TeacherSkill>(teacherSkill);
        model.addAttribute("pageInfo",pageInfo);
        return "user/status";
    }


}
