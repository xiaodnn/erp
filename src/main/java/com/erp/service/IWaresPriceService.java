/**
 * 
 */
package com.erp.service;

import com.erp.orm.entity.WaresPrice;

/**
 * 商品价格信息
 *
 * @author scy
 * @date 2016年12月14日
 */
public interface IWaresPriceService {

    int delById(String wId);

    int save(WaresPrice waresPrice);

    int saveNotNull(WaresPrice waresPrice);

    WaresPrice findById(String wId);

    int modifyByIdNotNull(WaresPrice waresPrice);

    int modifyById(WaresPrice waresPrice);

    int modifyByWid(String wid, Float wCostprice, Float wSaleprice);

    int saveOrModify(WaresPrice waresPrice);

}
