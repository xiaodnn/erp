package com.erp.service;

import com.erp.orm.entity.Store;

import java.util.List;

public interface IStoreService {
    int delById(Integer sId);

    int save(Store store);

    int saveNotNull(Store store);

    Store findById(Integer sId);

    int modifyByIdNotNull(Store store);

    int modifyById(Store store);

    Store findByCode(String oCode);

    List<Store> findByPage(Integer page, Integer rows);

    Integer findCount();

    int saveOrModify(Store store);

    int modifyByWid(Store store);

    List<Store> findByWid(String wId);

    int modifyAmountById(Integer sId, Float amount);
}
