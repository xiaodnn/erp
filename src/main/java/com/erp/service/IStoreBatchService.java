package com.erp.service;



import java.util.List;

import com.erp.orm.entity.StoreBatch;

public interface IStoreBatchService {
    int delById(Integer sbId);

    int save(StoreBatch storeBatch);

    int saveNotNull(StoreBatch storeBatch);

    StoreBatch findById(Integer sbId);

    int modifyByIdNotNull(StoreBatch storeBatch);

    int modifyById(StoreBatch storeBatch);

    StoreBatch findByCode(String oCode);

    List<StoreBatch> findByPage(Integer page, Integer rows);

    Integer findCount();

    int modifyAmountById(Integer sbId, Float amount);
}
