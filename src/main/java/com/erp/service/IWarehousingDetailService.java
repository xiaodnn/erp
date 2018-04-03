/**
 * 
 */
package com.erp.service;

import com.erp.orm.entity.WarehousingDetail;

/**
 * 入库信息明细
 *
 * @author scy
 * @date 2017年1月2日
 */
public interface IWarehousingDetailService {

    int delById(String whId,String wId);

    int save(WarehousingDetail warehousingDetail);

    int saveNotNull(WarehousingDetail warehousingDetail);

    WarehousingDetail findById(Integer wdId);

    int modifyByIdNotNull(WarehousingDetail warehousingDetail);

    int modifyById(WarehousingDetail warehousingDetail);
	
}
