package com.wjl.teacher_management.repository;

import com.wjl.teacher_management.bean.Teacher;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/3 22:16
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Mapper
public interface TeacherMapper {

    List<Teacher> selectAll();

    boolean update(Teacher teacher);

    int insert(Teacher teacher);

    Teacher findById(Integer id);

    Teacher selectTeacherByUsername(String username);

    int request(@Param("tid") int tid,@Param("sid")  int sid);
    //查找是否存在
    int isRepeat(@Param("tid") int tid,@Param("sid")  int sid);

    List<TeacherSkill> status (@Param("tid") int tid);
    int insertTes(Teacher teacher);

}