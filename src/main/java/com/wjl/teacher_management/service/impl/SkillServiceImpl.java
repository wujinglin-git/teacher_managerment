package com.wjl.teacher_management.service.impl;

import com.wjl.teacher_management.bean.Skill;
import com.wjl.teacher_management.repository.SkillMapper;
import com.wjl.teacher_management.service.SkillService;
import com.wjl.teacher_management.service.vo.StatisticVo;
import com.wjl.teacher_management.service.vo.TeacherSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wugege
 * @Date: 2020/3/5 15:45
 * 一给窝哩 giao giao 呀吼
 * 4
 */
@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillMapper skillMapper;

    @Override
    public List<Skill> findAll() {

        return skillMapper.selectAll();
    }

    @Override
    public Skill findById(int id) {
        return skillMapper.selectById(id);
    }

    @Override
    public boolean deleteByid(int id) {
        return false;
    }

    @Override
    public boolean update(Skill skill) {
        return skillMapper.update(skill);
    }

    @Override
    public boolean save(Skill skill) {

        return skillMapper.save(skill);
    }

    @Override
    public List<TeacherSkill> selectState() {
        return skillMapper.selectAllSta();
    }

    @Override
    public int updateState(Integer id, Integer state) {
        return skillMapper.updateState(id,state);
    }

    @Override
    public List<StatisticVo> findStatistic() {
        return skillMapper.selectSt();
    }
}
