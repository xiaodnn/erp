package com.erp.orm.inter;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("baseMapper")
public interface IBaseMapper<T> {

    int insert(T t);

    int insertSelective(T t);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    T selectByPrimaryKey(String id);

    List<T> selectAll();

    List<T> selectByName(String name);

    List<T> selectByPage(Map<String,Object> map);

    Integer selectCount(Map<String, Object> map);

}
