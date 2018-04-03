package com.erp.service;



import com.erp.orm.entity.StorePlace;

import java.util.List;

public interface IStorePlaceService {
    int delById(Integer spId);

    int save(StorePlace storeplace);

    int saveNotNull(StorePlace storeplace);

    StorePlace findById(Integer spId);

    int modifyByIdNotNull(StorePlace storeplace);

    int modifyById(StorePlace storeplace);

    List<StorePlace> findByPage(Integer page, Integer rows);

    Integer findCount();

    StorePlace findByCode(String spCode);
}
