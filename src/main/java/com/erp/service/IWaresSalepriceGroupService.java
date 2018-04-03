package com.erp.service;


import java.util.List;

import com.erp.orm.entity.WaresSalepriceGroup;
import com.erp.orm.entity.WaresSalepriceGroupKey;

public interface IWaresSalepriceGroupService {
    int delById(WaresSalepriceGroupKey key);

    int save(WaresSalepriceGroup waresSalepriceGroup);

    int saveNotNull(WaresSalepriceGroup waresSalepriceGroup);

    WaresSalepriceGroup findById(WaresSalepriceGroupKey key);

    int modifyByIdNotNull(WaresSalepriceGroup waresSalepriceGroup);

    int modifyById(WaresSalepriceGroup waresSalepriceGroup);

	List<WaresSalepriceGroup> findByName(String name);

	List<WaresSalepriceGroup> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
