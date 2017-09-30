package com.glemontree.mybatis.controller;

import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public String login(Student student, Model model) {
        String info = loginUser(student);
        if (!"SUCC".equals(info)) {
            model.addAttribute("failMsg", "用户不存在或密码错误");
            return "fail";
        } else {
            model.addAttribute("successMsg", "登录成功");
            model.addAttribute("name", student.getName());
            return "success";
        }
    }

    private String loginUser(Student student) {
        if (isReLogin(student)) return "success";
        return shiroLogin(student);
    }

    private String shiroLogin(Student student) {
        UsernamePasswordToken token = new UsernamePasswordToken(student.getName(), student.getPassword(), null);
        token.setRememberMe(true);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException exception) {
            return "用户名不存在或者密码错误";
        } catch (IncorrectCredentialsException exception) {
            return "用户名不存在或密码错误";
        } catch (AuthenticationException exception) {
            return exception.getMessage();
        } catch (Exception exception) {
            exception.printStackTrace();
            return "内部错误，请重试";
        }
        return "SUCC";
    }

    private boolean isReLogin(Student student) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return true;
        }
        return false;
    }

}
