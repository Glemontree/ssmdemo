package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.bean.Permission;

public interface PermissionMapper {

    public int deleteById(Integer id);

    public int insert(Permission permission);

    public Permission selectById(Integer id);

    public int updateById(Permission permission);
}
