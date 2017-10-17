package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.base.BaseMapper;
import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
	
    public Student getStudentById(Integer id);
    
    public Student getStudentByName(String name);
    
    public Student getStudentByStudentId(String studentId);
    
    public List<Student> getStudentsByClazz(Clazz clazz);

    public List<Student> getStudentsByClazzId(Integer clazzId);

}
