package com.erp.service;



import com.erp.orm.entity.StoreZone;

import java.util.List;

public interface IStoreZoneService {
    int delById(Integer szId);

    int save(StoreZone storeZone);

    int saveNotNull(StoreZone storeZone);

    StoreZone findById(Integer szId);

    int modifyByIdNotNull(StoreZone storeZone);

    int modifyById(StoreZone storeZone);

    List<StoreZone> findByPage(Integer page, Integer rows);

    Integer findCount();

    StoreZone findByCode(String szCode);
}
