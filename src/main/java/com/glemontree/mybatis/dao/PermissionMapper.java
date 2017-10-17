package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.base.BaseMapper;
import com.glemontree.mybatis.bean.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    public int deleteById(Integer id);

    public Permission selectById(Integer id);

    public int updateById(Permission permission);

    public List<Permission> selectPermissionsByRoleId(Integer role_id);
}
