/**
 * 
 */
package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Wares;

/**
 *
 *
 * @author scy
 * @date 2016年9月29日
 */
public interface IWaresDao {

	int deleteByPrimaryKey(String wId);

	int insert(Wares wares);

	int insertSelective(Wares wares);

	Wares selectByPrimaryKey(String wId);

	int updateByPrimaryKeySelective(Wares wares);

	int updateByPrimaryKey(Wares wares);

	/**
	 * 获取所有商品信息
	 * @return
	 */
	List<Wares> selectAll();

	/**
	 * 根据商品名称获取商品信息
	 * @param wTraname
	 * @return
	 */
	List<Wares> selectByName(String wTraname);

	/**
	 * 入库时根据名称或商品简码或商品编号查询
	 * @param s
	 * @return
	 */
	List<Wares> selectByNameOrId(String s);

	/**
	 * 根据商品名称助记码获取商品信息、批次信息、库存明细信息
	 * @param zjm
	 * @return
	 */
	List<Wares> selectByZjmOrId(String zjm);


	List<Wares> selectByPage(Integer page, Integer rows);

	Integer selectCount();
}
