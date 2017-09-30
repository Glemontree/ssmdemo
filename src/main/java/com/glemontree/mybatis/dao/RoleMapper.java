package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.bean.Role;

public interface RoleMapper {

    public int deleteById(Integer id);

    public int insert(Role role);

    public Role selectById(Integer id);

    public int updateById(Role role);
}
