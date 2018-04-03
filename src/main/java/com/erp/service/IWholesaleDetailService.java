package com.erp.service;


import java.util.List;

import com.erp.orm.entity.WholesaleDetail;

public interface IWholesaleDetailService {
    int delById(Integer wsdId);

    int save(WholesaleDetail wholesaleDetail);

    int saveNotNull(WholesaleDetail wholesaleDetail);

    WholesaleDetail findById(Integer wsdId);

    int modifyByIdNotNull(WholesaleDetail wholesaleDetail);

    int modifyById(WholesaleDetail wholesaleDetail);

	WholesaleDetail findByCode(String oCode);

	List<WholesaleDetail> findByPage(Integer page, Integer rows);

	Integer findCount( );

    List<WholesaleDetail> findByName(String name);

    /**
     * 根据批发销售单删除批发销售明细
     * @param wsId
     * @return
     */
    int delByWsId(Integer wsId);

    /**
     * 根据 删除批发销售明显
     * @param wsId 批发销售但ID
     * @param wId 商品ID
     * @param batchNo 批号
     * @param sbId 批次
     * @return
     */
    int delByWsIdAndWidAndBatchnoAndSbid(Integer wsId, Integer wId, String batchNo, Integer sbId);
}
