package com.wjl.teacher_management.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjl.teacher_management.bean.Skill;
import com.wjl.teacher_management.common.constant.PaginationConstant;
import com.wjl.teacher_management.common.util.ResponseResult;
import com.wjl.teacher_management.service.RoleSerciece;
import com.wjl.teacher_management.service.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/1 11:38
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Controller
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    RoleSerciece roleservice;



    @GetMapping("/roles")
    public String list( Model model){
//        if(ObjectUtils.isEmpty(pageNum)||pageNum<1){
//            pageNum= PaginationConstant.PAGE_NUM;
//        }
//        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        List<RoleVo> list = roleservice.selectAll();


        model.addAttribute("list",list);

        return "role_manager";
    }
    @GetMapping("/give")
    @ResponseBody
    public ResponseResult give( Integer id){
        ResponseResult result  =new ResponseResult();
        roleservice.addRole(id);
        result.setMessage("success");
        return result;
    }
    @GetMapping("/back")
    @ResponseBody
    public ResponseResult back(Integer id){
        ResponseResult result  =new ResponseResult();
        roleservice.remRole(id);
            result.setMessage("success");
        return result;
    }

}
