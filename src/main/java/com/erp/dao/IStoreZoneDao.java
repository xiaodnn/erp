package com.erp.dao;


import java.util.List;

import com.erp.orm.entity.StoreZone;

public interface IStoreZoneDao {
    int deleteByPrimaryKey(Integer szId);

    int insert(StoreZone storeZone);

    int insertSelective(StoreZone storeZone);

    StoreZone selectByPrimaryKey(Integer szId);

    int updateByPrimaryKeySelective(StoreZone storeZone);

    int updateByPrimaryKey(StoreZone storeZone);

    List<StoreZone> selectByPage(Integer page, Integer rows);

    Integer selectCount();

    StoreZone selectByCode(String szCode);
}
