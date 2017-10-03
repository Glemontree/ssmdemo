package com.glemontree.mybatis.shiro;

import com.glemontree.mybatis.bean.Permission;
import com.glemontree.mybatis.bean.Role;
import com.glemontree.mybatis.bean.Student;
import com.glemontree.mybatis.bean.Teacher;
import com.glemontree.mybatis.service.PermissionService;
import com.glemontree.mybatis.service.RoleService;
import com.glemontree.mybatis.service.StudentService;
import com.glemontree.mybatis.service.TeacherService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private StudentService studentService;

    /*@Autowired
    private TeacherService teacherService;*/

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        String name = String.valueOf(principalCollection.getPrimaryPrincipal());
        Student student = null;
        Teacher teacher = null;
        student = studentService.getStudentByName(name);
        List<Role> roleInfos = null;
        if (student != null) {
            roleInfos = roleService.selectRolesByStudentId(student.getId());
        } else {
            roleInfos = roleService.selectRolesByTeacherId(teacher.getId());
        }
        for (Role role : roleInfos) {
            System.out.println(role);
            authenticationInfo.addRole(role.getRoleSign());
            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
                System.out.println(permission);
                authenticationInfo.addStringPermission(permission.getPermissionSign());
            }
        }
        return authenticationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*// 用户名
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
        return simpleAuthenticationInfo;*/
        String name = String.valueOf(authenticationToken.getPrincipal());
        String password = new String((char[]) authenticationToken.getCredentials());
        final Student student = studentService.authentication(new Student(name, password));
        if (student == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(name, password, getName());
        return authenticationInfo;
    }

    /*private Student tokenToStudent(UsernamePasswordToken usernamePasswordToken) {
        Student student = new Student();
        student.setName(usernamePasswordToken.getUsername());
        student.setPassword(String.valueOf(usernamePasswordToken.getPassword()));
        return student;
    }*/
}
