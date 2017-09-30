package com.glemontree.mybatis.controller;

import com.glemontree.mybatis.bean.Permission;
import com.glemontree.mybatis.service.PermissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/selectPermission")
    public void selectPermission(@Param("id") Integer id) {
        Permission permission = permissionService.selectById(id);
        System.out.println(permission);
    }
}
