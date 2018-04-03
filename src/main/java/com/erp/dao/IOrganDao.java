package com.erp.dao;


import java.util.List;

import com.erp.orm.entity.Organ;

public interface IOrganDao {
    int deleteByPrimaryKey(Integer oId);

    int insert(Organ organ);

    int insertSelective(Organ organ);

    Organ selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(Organ organ);

    int updateByPrimaryKey(Organ organ);

    List<Organ> selectByName(String oName);

    Organ selectByCode(String oCode);

    List<?> selectByPage(Integer page, Integer rows);

    Integer selectCount();
}
