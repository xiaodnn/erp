package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.WholesaleDetail;

public interface IWholesaleDetailDao {
    int deleteByPrimaryKey(Integer wsdId);

    int insert(WholesaleDetail wholesaleDetail);

    int insertSelective(WholesaleDetail wholesaleDetail);

    WholesaleDetail selectByPrimaryKey(Integer wsdId);

    int updateByPrimaryKeySelective(WholesaleDetail wholesaleDetail);

    int updateByPrimaryKey(WholesaleDetail wholesaleDetail);

	WholesaleDetail selectByCode(String oCode);

	List<WholesaleDetail> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

    List<WholesaleDetail> selectByName(String name);

    /**
     * 根据批发销售单删除批发销售明细
     * @param wsId
     * @return
     */
    int deleteByWsId(Integer wsId);

    /**
     *
     * 根据 删除批发销售明显
     * @param wsId 批发销售但ID
     * @param wId 商品ID
     * @param batchNo 批号
     * @param sbId 批次
     * @return
     */
    int deleteByWsIdAndWidAndBatchnoAndSbid(Integer wsId, Integer wId, String batchNo, Integer sbId);
}
