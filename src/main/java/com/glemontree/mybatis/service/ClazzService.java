package com.glemontree.mybatis.service;

import com.glemontree.mybatis.bean.Clazz;
import com.glemontree.mybatis.dao.ClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    public Clazz getClazzByName(String name) {
        return clazzMapper.getClazzByName(name);
    }
}
