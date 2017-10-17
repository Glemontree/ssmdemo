package com.glemontree.mybatis.dao;

import com.glemontree.mybatis.base.BaseMapper;
import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.bean.Student;

import java.util.List;

public interface ClazzMapper extends BaseMapper<Clazz> {
	
    public Clazz getClazzById(Integer id);

    public Clazz getClazzByName(String name);

    public List<Clazz> getClazzesByTeacherId(Integer teacherId);

}
