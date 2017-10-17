package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.base.BaseMapper;
import com.glemontree.mybatis.bean.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    public int deleteById(Integer id);

    public Role selectById(Integer id);

    public int updateById(Role role);

    public List<Role> selectRolesByStudentId(Integer id);

    public List<Role> selectRolesByTeacherId(Integer id);
}
