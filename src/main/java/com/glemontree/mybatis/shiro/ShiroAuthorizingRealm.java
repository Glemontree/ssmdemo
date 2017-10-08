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
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        String name = String.valueOf(principalCollection.getPrimaryPrincipal());
        Student student = null;
        Teacher teacher = null;
        List<Role> roleInfos = null;
        if ((student = studentService.getStudentByName(name)) != null) {
            roleInfos = roleService.selectRolesByStudentId(student.getId());
        } else if ((teacher = teacherService.getTeacherByName(name)) != null) {
            roleInfos = roleService.selectRolesByTeacherId(teacher.getId());
        } else {
            return null;
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
        String name = String.valueOf(authenticationToken.getPrincipal());
        final Student student = studentService.getStudentByName(name);
        if (student == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                student.getName(),
                student.getPassword(),
                getName()
        );
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(student.getCredentialSalt()));
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
