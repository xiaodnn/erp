package com.erp.dao;


import java.util.List;

import com.erp.orm.entity.Store;

public interface IStoreDao {
    int deleteByPrimaryKey(Integer sId);

    int insert(Store store);

    int insertSelective(Store store);

    Store selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Store store);

    int updateByPrimaryKey(Store store);

    List<Store> selectByPage(Integer page, Integer rows);

    Store selectByCode(String spCode);

    Integer selectCount();

    int insertOrUpdate(Store store);

    int updateByWid(Store store);

    List<Store> selectByWid(String wId);

    int updateAmountById(Integer sId, Float amount);
}
