package com.erp.service;


import java.util.List;

import com.erp.orm.entity.WholesaleApplyDetail;

public interface IWholesaleApplyDetailService {
    int delById(Integer wadId);

    /**
     * 根据 批发申请单ID 和 商品ID删除批发申请单明细
     * @param waId 批发申请单ID
     * @param wId 商品ID
     * @return
     */
    int delByWaIdAndWid(String waId,String wId);

    int save(WholesaleApplyDetail wholesaleApplyDetail);

    int saveNotNull(WholesaleApplyDetail wholesaleApplyDetail);

    WholesaleApplyDetail findById(Integer wadId);

    int modifyByIdNotNull(WholesaleApplyDetail wholesaleApplyDetail);

    int modifyById(WholesaleApplyDetail wholesaleApplyDetail);

	WholesaleApplyDetail findByCode(String oCode);

	List<WholesaleApplyDetail> findByPage(Integer page, Integer rows,Integer waId);

	Integer findCount( );

    List<WholesaleApplyDetail> findByName(String name);
}
