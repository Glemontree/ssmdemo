package com.glemontree.mybatis.controller;

import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public String login() {
        Student student = studentService.getStudentById(1);
        System.out.println(student);
        return "login";
    }

}
