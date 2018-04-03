/**
 * 
 */
package com.erp.service;

import java.util.List;

import com.erp.orm.entity.Wares;
import com.erp.orm.entity.WaresBase;
import com.erp.orm.entity.WaresExtend;
import com.erp.orm.entity.WaresPrice;

/**
 *
 *
 * @author scy
 * @date 2016年9月29日
 */
public interface IWaresService {

	int delById(String wId);

	int save(WaresBase base, WaresExtend extend, WaresPrice price);

	int saveNotNull(WaresBase base, WaresExtend extend, WaresPrice price);

	Wares findById(String wId);

	int modifyByIdIsNull(Wares wares);

	int modifyById(Wares wares);

	/**
	 * 获取所有商品信息
	 * @return
	 */
	List<Wares> findAll();

	/**
	 * 根据商品名称获取商品信息
	 * @param wTraname
	 * @return
	 */
	List<Wares> findByName(String wTraname);

	/**
	 * 入库时根据名称或商品简码或商品编号查询
	 * @param s
	 * @return
	 */
	List<Wares> findByNameOrId(String s);

	/**
	 * 根据商品名称助记码获取商品信息、批次信息、库存明细信息
	 * @param zjm
	 * @return
	 */
	List<Wares> findByZjmOrId(String zjm);

    List<Wares> findByPage(Integer page, Integer rows);

	Integer findCount();
}
