package com.erp.dao;


import com.erp.orm.entity.StoreHouse;

import java.util.List;

public interface IStoreHouseDao {
    int deleteByPrimaryKey(Integer shId);

    int insert(StoreHouse storehouse);

    int insertSelective(StoreHouse storehouse);

    StoreHouse selectByPrimaryKey(Integer shId);

    List<StoreHouse> selectAll();

    int updateByPrimaryKeySelective(StoreHouse storehouse);

    int updateByPrimaryKey(StoreHouse storehouse);

    StoreHouse selectByCode(String shCode);

    Integer selectCount();

    List<StoreHouse> selectByPage(Integer page, Integer rows);
}
