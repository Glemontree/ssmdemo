package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;

import java.util.List;

public interface StudentMapper {
	
    public Student getStudentById(Integer id);
    
    public Student getStudentByName(String name);
    
    public Student getStudentByStudentId(String studentId);
    
    public List<Student> getStudentsByClazz(Clazz clazz);

    public void insert(Student student);
    
}
