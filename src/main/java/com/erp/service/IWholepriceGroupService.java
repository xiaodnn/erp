package com.erp.service;


import java.util.List;

import com.erp.orm.entity.WholepriceGroup;

public interface IWholepriceGroupService {
    int delById(Integer wpgId);

    int save(WholepriceGroup wholepriceGroup);

    int saveNotNull(WholepriceGroup wholepriceGroup);

    WholepriceGroup findById(Integer wpgId);

    int modifyByIdNotNull(WholepriceGroup wholepriceGroup);

    int modifyById(WholepriceGroup wholepriceGroup);

    List<WholepriceGroup> findByName(String name);

	List<WholepriceGroup> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
