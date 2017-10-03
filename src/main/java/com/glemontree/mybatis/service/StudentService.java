package com.glemontree.mybatis.service;

import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    public Student getStudentByName(String name) {
        return studentMapper.getStudentByName(name);
    }

    public void insert(Student student) {
        studentMapper.insert(student);
    }

    public Student authentication(Student student) {
        return studentMapper.authentication(student);
    }
}
