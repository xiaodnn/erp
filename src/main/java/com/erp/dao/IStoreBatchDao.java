package com.erp.dao;


import java.util.List;

import com.erp.orm.entity.StoreBatch;

public interface IStoreBatchDao {
    int deleteByPrimaryKey(Integer sbId);

    int insert(StoreBatch storeBatch);

    int insertSelective(StoreBatch storeBatch);

    StoreBatch selectByPrimaryKey(Integer sbId);

    int updateByPrimaryKeySelective(StoreBatch storeBatch);

    int updateByPrimaryKey(StoreBatch storeBatch);

    StoreBatch selectByCode(String oCode);

    List<StoreBatch> selectByPage(Integer page, Integer rows);

    Integer selectCount();

    int updateAmountById(Integer sbId, Float amount);
}
