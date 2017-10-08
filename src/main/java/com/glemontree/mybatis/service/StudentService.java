package com.glemontree.mybatis.service;

import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.dao.StudentMapper;
import com.glemontree.mybatis.utils.Utils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
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
        String algorithmName = "md5";
        String salt1 = student.getName();
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash(algorithmName, student.getPassword(), salt1 + salt2, hashIterations);
        student.setPassword(hash.toHex());
        student.setSalt(salt2);
        studentMapper.insert(student);
    }

}
