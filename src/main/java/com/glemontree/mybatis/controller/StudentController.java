package com.glemontree.mybatis.controller;

import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.service.ClazzService;
import com.glemontree.mybatis.service.StudentService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ClazzService clazzService;

    /**
     * get a student from the database and return it as json
     * @param id the id of the student
     * @return
     */
    @RequestMapping("/getStudentById")
    @ResponseBody
    public Map<String, Object> getStudentById(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
        Student student = studentService.getStudentById(11);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        Map<String, Object> studentJsonMap = new HashMap<String, Object>();
        studentJsonMap.put("name", student.getName());
        studentJsonMap.put("sex", student.getSex());
        studentJsonMap.put("student_id", student.getStudentId());
        studentJsonMap.put("class", student.getClazz().getName());
        map.put("data", studentJsonMap);
        return map;
    }

    @RequestMapping("/getAllStudentsByClazzName")
    @ResponseBody
    public Map<String, Object> getAllStudents(@RequestParam(value = "clazzName", required = false, defaultValue = "class 1") String clazzName) {
        Clazz clazz = clazzService.getClazzByName(clazzName);
        List<Student> students = clazz.getStudents();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);

        List<Map<String, Object>> list = new LinkedList<>();
        Map<String, Object> map1 = null;

        for (Student student : students) {
            map1 = new HashMap<>();
            map1.put("name", student.getName());
            map1.put("sex", student.getSex());
            map1.put("student_id", student.getStudentId());
            map1.put("class_name", clazzName);
            list.add(map1);
        }

        map.put("data", list);
        return map;
    }

    /**
     * insert a student to the database
     */
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

    /**
     * just for json test
     * @return
     */
    @RequestMapping("/jsonTest")
    @ResponseBody
    public Map<String, Object> jsonTest() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("Work", "研发");
        modelMap.put("School", "NUAA");
        modelMap.put("Place", "上海");
        return modelMap;
    }

    @RequestMapping("/getStudentByName")
    public String getStudentByName(@RequestParam(value = "name", required = false, defaultValue = "zhangsan") String name) {
        Student student = studentService.getStudentByName(name);
        System.out.println(student);
        return null;
    }
}
