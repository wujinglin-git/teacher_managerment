package com.wjl.teacher_management.service.impl;

import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import com.wjl.teacher_management.repository.TeacherMapper;
import com.wjl.teacher_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/2 22:02
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAll() {

        return teacherMapper.selectAll();
    }

    @Override
    public Teacher findById(Integer id) {

        return teacherMapper.findById(id);
    }

    @Override
    public Boolean update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }


    @Override
    public  int insert(){
        Teacher teacher;
        for (int i = 0; i < 50; i++) {
            teacher = new Teacher("qwe"+i,i%2,new Date(),"工学院","教工",new Date(),"本科");
            teacherMapper.insert(teacher);
        }

        return 1;
    }

    @Override
    public Teacher findByUsername(String username) {
        return teacherMapper.selectTeacherByUsername(username);
    }

    @Override
    public int reqIsExist(int tid, int sid) {
        return teacherMapper.isRepeat(tid,sid);
    }

    @Override
    public int req(int tid,int sid) {
        return teacherMapper.request(tid,sid);
    }

    @Override
    public  List<TeacherSkill> status(int tid) {
        return teacherMapper.status(tid);
    }

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }
}
