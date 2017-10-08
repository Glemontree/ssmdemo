package com.glemontree.mybatis.service;

import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.bean.Teacher;
import com.glemontree.mybatis.dao.StudentMapper;
import com.glemontree.mybatis.dao.TeacherMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }

    public Teacher getTeacherByName(String name) {
        return teacherMapper.getTeacherByName(name);
    }

    public void insert(Teacher teacher) {
        String algorithmName = "md5";
        String salt1 = teacher.getName();
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash(algorithmName, teacher.getPassword(), salt1 + salt2, hashIterations);
        teacher.setPassword(hash.toHex());
        teacher.setSalt(salt2);
        teacherMapper.insert(teacher);
    }
}
