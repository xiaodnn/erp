package com.erp.service;


import java.util.List;

import com.erp.orm.entity.WholesaleApply;

public interface IWholesaleApplyService {
    int delById(Integer waId);

    int save(WholesaleApply wholesaleApply);

    int saveNotNull(WholesaleApply wholesaleApply);

    WholesaleApply findById(Integer waId);

    int modifyByIdNotNull(WholesaleApply wholesaleApply);

    int modifyById(WholesaleApply wholesaleApply);

	WholesaleApply findByCode(String oCode);

	List<WholesaleApply> findByPage(Integer page, Integer rows,Integer waId);

	Integer findCount( );

    List<WholesaleApply> findByName(String name);
}
