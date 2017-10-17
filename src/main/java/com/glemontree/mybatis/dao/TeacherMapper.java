package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.base.BaseMapper;
import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.bean.Teacher;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {
	
    public Teacher getTeacherByName(String name);

    public Teacher getTeacherById(Integer id);

}
