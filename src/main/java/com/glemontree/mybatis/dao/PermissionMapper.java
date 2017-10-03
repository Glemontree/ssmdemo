package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.bean.Permission;

import java.util.List;

public interface PermissionMapper {

    public int deleteById(Integer id);

    public int insert(Permission permission);

    public Permission selectById(Integer id);

    public int updateById(Permission permission);

    public List<Permission> selectPermissionsByRoleId(Integer role_id);
}
