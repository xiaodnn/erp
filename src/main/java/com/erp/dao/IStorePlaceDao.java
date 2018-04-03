package com.erp.dao;


import com.erp.orm.entity.StorePlace;

import java.util.List;

public interface IStorePlaceDao {
    int deleteByPrimaryKey(Integer spId);

    int insert(StorePlace storeplace);

    int insertSelective(StorePlace storeplace);

    StorePlace selectByPrimaryKey(Integer spId);

    int updateByPrimaryKeySelective(StorePlace storeplace);

    int updateByPrimaryKey(StorePlace storeplace);

    List<StorePlace> selectByPage(Integer page, Integer rows);

    Integer selectCount();

    StorePlace selectByCode(String shCode);
}
