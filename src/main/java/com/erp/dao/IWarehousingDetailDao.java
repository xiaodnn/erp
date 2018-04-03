/**
 * 
 */
package com.erp.dao;

import com.erp.orm.entity.WarehousingDetail;

/**
 * 入库信息明细
 *
 * @author scy
 * @date 2017年1月2日
 */
public interface IWarehousingDetailDao {

    int deleteByPrimaryKey(String whId,String wId);

    int insert(WarehousingDetail warehousingDetail);

    int insertSelective(WarehousingDetail warehousingDetail);

    WarehousingDetail selectByPrimaryKey(Integer wdId);

    int updateByPrimaryKeySelective(WarehousingDetail warehousingDetail);

    int updateByPrimaryKey(WarehousingDetail warehousingDetail);
    
}
