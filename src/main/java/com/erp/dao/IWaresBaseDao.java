/**
 * 
 */
package com.erp.dao;

import com.erp.orm.entity.WaresBase;

/**
 * 商品基本信息
 *
 * @author scy
 * @date 2016年12月14日
 */
public interface IWaresBaseDao {
	int deleteByPrimaryKey(String wId);

	int insert(WaresBase waresBase);

	int insertSelective(WaresBase waresBase);

	WaresBase selectByPrimaryKey(String wId);

	int updateByPrimaryKeySelective(WaresBase waresBase);

	int updateByPrimaryKey(WaresBase waresBase);
}
