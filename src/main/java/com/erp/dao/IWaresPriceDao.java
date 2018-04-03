/**
 * 
 */
package com.erp.dao;

import com.erp.orm.entity.WaresPrice;

/**
 * 商品价格信息
 *
 * @author scy
 * @date 2016年12月14日
 */
public interface IWaresPriceDao {

    int deleteByPrimaryKey(String wId);

    int insert(WaresPrice waresPrice);

    int insertSelective(WaresPrice waresPrice);

    WaresPrice selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(WaresPrice waresPrice);

    int updateByPrimaryKey(WaresPrice waresPrice);

    int updateByWid(String wid,Float wCostprice,Float wSaleprice);

    int insertOrUpdate(WaresPrice waresPrice);

}
