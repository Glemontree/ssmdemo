package com.glemontree.mybatis.shiro;

import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.service.StudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private StudentService studentService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 用户名
        Student studentLogin = tokenToStudent((UsernamePasswordToken) authenticationToken);
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        try {
            Student student = studentService.getStudentByName(studentLogin.getName());
            if (student == null) {
                throw new UnknownAccountException(); // 没找到相关账号
            }
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    studentLogin.getPassword(),
                    getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthenticationInfo;
    }

    private Student tokenToStudent(UsernamePasswordToken usernamePasswordToken) {
        Student student = new Student();
        student.setName(usernamePasswordToken.getUsername());
        student.setPassword(String.valueOf(usernamePasswordToken.getPassword()));
        return student;
    }
}
