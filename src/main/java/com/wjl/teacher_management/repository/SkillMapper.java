package com.wjl.teacher_management.repository;

import com.wjl.teacher_management.bean.Role;
import com.wjl.teacher_management.bean.Skill;
import com.wjl.teacher_management.service.vo.StatisticVo;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/5 15:41
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Mapper
public interface SkillMapper {
    List<Skill> selectAll();

    Skill selectById(@Param("id") int id);

    boolean delete(@Param("id") int id);

    boolean update(Skill skill);

    boolean save(Skill skill);

    int isReapeat(@Param("tid") int tid,@Param("sid")  int sid);

    List<TeacherSkill> selectAllSta();

    int updateState(@Param("id") Integer id,@Param("state") Integer state);

    List<StatisticVo> selectSt();
}
