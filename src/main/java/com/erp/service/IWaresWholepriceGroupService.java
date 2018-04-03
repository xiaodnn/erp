package com.erp.service;


import java.util.List;

import com.erp.orm.entity.WaresWholepriceGroup;
import com.erp.orm.entity.WaresWholepriceGroupKey;

public interface IWaresWholepriceGroupService {
    int delById(WaresWholepriceGroupKey key);

    int save(WaresWholepriceGroup waresWholepriceGroup);

    int saveNotNull(WaresWholepriceGroup waresWholepriceGroup);

    WaresWholepriceGroup findById(WaresWholepriceGroupKey key);

    int modifyByIdNotNull(WaresWholepriceGroup waresWholepriceGroup);

    int modifyById(WaresWholepriceGroup waresWholepriceGroup);

	List<WaresWholepriceGroup> findByName(String name);

	List<WaresWholepriceGroup> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
