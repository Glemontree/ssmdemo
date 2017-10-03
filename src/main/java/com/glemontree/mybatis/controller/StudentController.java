package com.glemontree.mybatis.controller;

import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.service.ClazzService;
import com.glemontree.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ClazzService clazzService;

    @RequestMapping("/getStudentById")
    public void getStudentById(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
        Student student = studentService.getStudentById(2);
        System.out.println(student);
    }

    @RequestMapping("/insertStudent")
    public void insertStudent() {
        Clazz clazz = clazzService.getClazzById(1);
        Student student = new Student(null, "wangwu", "1230", "male", "SX1301130", clazz);
        studentService.insert(student);
    }

    @RequestMapping("/user/add")
    public String userAdd() {
        return "authorize";
    }
}
