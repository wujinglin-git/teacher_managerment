package com.wjl.teacher_management.service;

import com.wjl.teacher_management.bean.Skill;
import com.wjl.teacher_management.service.vo.StatisticVo;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/5 15:36
 * 一给窝哩 giao giao 呀吼
 * 4
 */
public interface SkillService {

    List<Skill> findAll();

    Skill findById(int id);


    boolean deleteByid(int id);

    boolean update(Skill skill);

    boolean save(Skill skill);

    List<TeacherSkill> selectState();


    int updateState(Integer id, Integer state);

    List<StatisticVo> findStatistic();

}
