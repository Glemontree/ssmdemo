package com.glemontree.mybatis.controller;

import com.glemontree.mybatis.bean.Role;
import com.glemontree.mybatis.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("selectRole")
    public void selectRole(@Param("id") Integer id) {
        Role role = roleService.selectById(id);
        System.out.println(role);
    }

}
