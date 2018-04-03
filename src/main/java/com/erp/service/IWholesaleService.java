package com.erp.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.erp.orm.entity.Wholesale;
import com.erp.utils.ResultJson;

public interface IWholesaleService {
    @Transactional
    int save(Wholesale wholesale) throws Exception;

//    int saveNotNull(Wholesale wholesale);
//    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
//    @Transactional
    ResultJson saveNotNull(Wholesale wholesale, String add, String del, String modify) throws Exception;
    @Transactional
    int delById(Integer wsId) throws Exception;

//    int modifyByIdNotNull(Wholesale wholesale);
    @Transactional
    ResultJson modifyByIdNotNull(Wholesale wholesale) throws Exception;
    @Transactional
    int modifyById(Wholesale wholesale) throws Exception;

	Wholesale findByCode(String oCode);

	List<Wholesale> findByPage(Integer page, Integer rows);

	Integer findCount( );

    List<Wholesale> findByName(String name);

    Wholesale findById(Integer wsId);

}
