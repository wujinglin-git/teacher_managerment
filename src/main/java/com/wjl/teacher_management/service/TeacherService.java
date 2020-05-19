package com.wjl.teacher_management.service;

import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/2 21:32
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(Integer id);

    Boolean update(Teacher teacher);

    int insert();

    Teacher findByUsername(String username);

    int reqIsExist(int tid, @Param("sid")  int sid);

    int req(int tid,int sid);

    List<TeacherSkill> status(int tid);

    int add(Teacher teacher);
}
