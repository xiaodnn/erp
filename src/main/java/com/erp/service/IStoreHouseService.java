package com.erp.service;



import com.erp.orm.entity.StoreHouse;

import java.util.List;

public interface IStoreHouseService {
    int delById(Integer shId);

    int save(StoreHouse storehouse);

    int saveNotNull(StoreHouse storehouse);

    StoreHouse findById(Integer shId);

    List<StoreHouse> findAll();

    int modifyByIdNotNull(StoreHouse storehouse);

    int modifyById(StoreHouse storehouse);

    List<StoreHouse> findByPage(Integer page, Integer rows);

    Integer findCount();

    StoreHouse findByCode(String shCode);
}
