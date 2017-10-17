package com.glemontree.mybatis.base;

import java.util.List;

public interface BaseMapper<T/* extends BasePage*/> {

    int insert(T entity);

    void delete(T entity);

    void update(T entity);

    List<T> findAll();

}
