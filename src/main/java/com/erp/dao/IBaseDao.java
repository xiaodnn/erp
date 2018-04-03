package com.erp.dao;

import java.util.List;

public interface IBaseDao<T> {

    int insert(T t);

    int insertSelective(T t);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    T selectByPrimaryKey(Integer id);

    List<T> selectAll();

    List<T> selectByPage(Integer page, Integer rows);

    Integer selectCount();
}
