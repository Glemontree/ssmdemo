package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.bean.Teacher;

import java.util.List;

public interface TeacherMapper {
	
    public Teacher getTeacherByName(String name);

    public void insert(Teacher teacher);

    public Teacher getTeacherById(Integer id);

}
