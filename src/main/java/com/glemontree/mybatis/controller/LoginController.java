package com.glemontree.mybatis.controller;

import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.bean.Teacher;
import com.glemontree.mybatis.bean.User;
import com.glemontree.mybatis.service.ClazzService;
import com.glemontree.mybatis.service.StudentService;
import com.glemontree.mybatis.service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    /**
     * 下面这两个没必要经过Controller
     * @return
     */
    @RequestMapping("/studentRegister")
    public String studentRegister() {
        return "studentRegister";
    }

    @RequestMapping("/teacherRegister")
    public String teacherRegister() {
        return "teacherRegister";
    }

    @RequestMapping("/studentRegisterSuccess")
    public String studentRegisterSuccess(Student student) {
        Clazz clazz = clazzService.getClazzByName(student.getClazz().getName());
        student.setClazz(clazz);
        studentService.insert(student);
        return "login";
    }

    @RequestMapping("/teacherRegisterSuccess")
    public String teacherRegisterSuccess(Teacher teacher) {
        teacherService.insert(teacher);
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(token);
            request.getSession().setAttribute("user", user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

}
