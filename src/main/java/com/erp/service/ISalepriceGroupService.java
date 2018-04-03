package com.erp.service;


import java.util.List;

import com.erp.orm.entity.SalepriceGroup;

public interface ISalepriceGroupService {
    int delById(Integer spgId);

    int save(SalepriceGroup salepriceGroup);

    int saveNotNull(SalepriceGroup salepriceGroup);

    SalepriceGroup findById(Integer spgId);

    int modifyByIdNotNull(SalepriceGroup salepriceGroup);

    int modifyById(SalepriceGroup salepriceGroup);

	List<SalepriceGroup> findByName(String name);

	List<SalepriceGroup> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
