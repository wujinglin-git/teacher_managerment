package com.wjl.teacher_management.controller.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjl.teacher_management.bean.Skill;
import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.common.constant.PaginationConstant;
import com.wjl.teacher_management.common.util.ResponseResult;
import com.wjl.teacher_management.service.SkillService;
import com.wjl.teacher_management.service.vo.StatisticVo;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/5 15:36
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Controller
@RequestMapping("/manager")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/skills")
    public String list(Integer pageNum, Model model){
        if(ObjectUtils.isEmpty(pageNum)||pageNum<1){
            pageNum= PaginationConstant.PAGE_NUM;
        }
        PageHelper.startPage(pageNum,8);

        List<Skill> skills = skillService.findAll();
        PageInfo<Skill> pageInfo = new PageInfo<>(skills);
        model.addAttribute("pageInfo",pageInfo);

        return "manager/skill_info";
    }
    @GetMapping("/audit")
    public String audit(Integer pageNum, Model model){

        if(ObjectUtils.isEmpty(pageNum)||pageNum<1){
            pageNum= PaginationConstant.PAGE_NUM;
        }

        List<TeacherSkill> list = skillService.selectState();
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        PageInfo<TeacherSkill> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);

        return "manager/audit";
    }

    @GetMapping("/toAdd")
    public String toAdd(){

        return "manager/add_Skill";
    }

    @PostMapping("/skill")
    public String addSkill(Skill skill){
        skillService.save(skill);

        return "redirect:/manager/skills";
    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Skill skill = skillService.findById(id);
        model.addAttribute("skill", skill);
        return "manager/skill_edit";
    }

    @PutMapping("/skill")
    public String editSkill(Skill skill){
        skillService.update(skill);

        return "redirect:/manager/skills";
    }

    @PutMapping("/audit")
    @ResponseBody
    public ResponseResult audit(Integer id,Integer state){
        ResponseResult result = new ResponseResult();
        skillService.updateState(id,state);
        result.setMessage("操作成功");
        return result;
    }

    @GetMapping("/statistic")
    public String statistic(Integer pageNum,Model model){

        if(ObjectUtils.isEmpty(pageNum)||pageNum<1){
            pageNum= PaginationConstant.PAGE_NUM;
        }
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        List<StatisticVo> list = skillService.findStatistic();

        PageInfo<StatisticVo> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);



        return "/manager/statistics";
    }

    @GetMapping("/upload")
    public String upload(){



        return "/manager/upload";
    }
}
