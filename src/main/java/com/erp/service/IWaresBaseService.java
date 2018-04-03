/**
 * 
 */
package com.erp.service;

import com.erp.orm.entity.WaresBase;

/**
 *  商品基本信息
 *
 * @author scy
 * @date 2016年12月14日
 */
public interface IWaresBaseService {

	int delByPrimaryKey(String wId);

	int save(WaresBase waresBase);

	int saveNotNull(WaresBase waresBase);

	WaresBase findById(String wId);

	int modifyByIdNotNull(WaresBase waresBase);

	int modifyById(WaresBase waresBase);
}
