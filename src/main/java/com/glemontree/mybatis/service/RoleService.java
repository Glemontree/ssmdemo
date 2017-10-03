package com.glemontree.mybatis.service;

import com.glemontree.mybatis.bean.Role;
import com.glemontree.mybatis.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public int deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    public Role selectById(Integer id) {
        return roleMapper.selectById(id);
    }

    public int updateById(Role role) {
        return roleMapper.updateById(role);
    }

    public List<Role> selectRolesByStudentId(Integer id) {
        return roleMapper.selectRolesByStudentId(id);
    }

    public List<Role> selectRolesByTeacherId(Integer id) {
        return roleMapper.selectRolesByTeacherId(id);
    }
}
