package com.erp.service;

import com.erp.orm.entity.StoreDetail;

import java.util.List;

public interface IStoreDetailService {
    int delById(Integer sdId);

    int save(StoreDetail storeDetail);

    int saveNotNull(StoreDetail storeDetail);

    StoreDetail findById(Integer sdId);

    int modifyByIdNotNull(StoreDetail storeDetail);

    int modifyById(StoreDetail storeDetail);

    StoreDetail findByCode(String oCode);

    List<StoreDetail> findByPage(Integer page, Integer rows);

    Integer findCount();

    /**
     * 根据库存主表ID查询库存明细
     * @param sId
     * @return
     */
    List<StoreDetail> findBySid(Integer sId);

    int modifyAmountById(Integer sdId, Float amount);
}
