package com.erp.dao;

import com.erp.orm.entity.StoreDetail;

import java.util.List;

public interface IStoreDetailDao {
    int deleteByPrimaryKey(Integer sdId);

    int insert(StoreDetail storeDetail);

    int insertSelective(StoreDetail storeDetail);

    StoreDetail selectByPrimaryKey(Integer sdId);

    int updateByPrimaryKeySelective(StoreDetail storeDetail);

    int updateByPrimaryKey(StoreDetail storeDetail);

    StoreDetail selectByCode(String oCode);

    List<StoreDetail> selectByPage(Integer page, Integer rows);

    Integer selectCount();

    List<StoreDetail> selectBySid(Integer sId);

    int updateAmountById(Integer sdId, Float amount);
}
