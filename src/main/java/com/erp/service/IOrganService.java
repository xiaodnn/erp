package com.erp.service;



import com.erp.orm.entity.Organ;

import java.util.List;

public interface IOrganService {
    int delById(Integer oId);

    int save(Organ organ);

    int saveNotNull(Organ organ);

    Organ findById(Integer oId);

    int modifyByIdNotNull(Organ organ);

    int modifyById(Organ organ);

    Organ findByCode(String oCode);

    List<?> findByPage(Integer page, Integer rows);

    Integer findCount();

    List<Organ> findByName(String oName);
}
