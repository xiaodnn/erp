package com.erp.dao.impl;

import com.erp.orm.inter.ISalepriceGroupMapper;
import com.erp.dao.ISalepriceGroupDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.SalepriceGroup;

@Repository("salepriceGroupDao")
public class SalepriceGroupDaoImpl implements  ISalepriceGroupDao {
	@Resource
	private ISalepriceGroupMapper salepriceGroupMapper;


	@Override
	public int deleteByPrimaryKey(Integer spgId){
		return salepriceGroupMapper.deleteByPrimaryKey(spgId);
	}



	@Override
	public int insert(SalepriceGroup salepriceGroup){
		return salepriceGroupMapper.insert(salepriceGroup);
	}



	@Override
	public int insertSelective(SalepriceGroup salepriceGroup){
		return salepriceGroupMapper.insertSelective(salepriceGroup);
	}



	@Override
	public SalepriceGroup selectByPrimaryKey(Integer spgId){
		return salepriceGroupMapper.selectByPrimaryKey(spgId);
	}



	@Override
	public int updateByPrimaryKeySelective(SalepriceGroup salepriceGroup){
		return salepriceGroupMapper.updateByPrimaryKeySelective(salepriceGroup);
	}



	@Override
	public int updateByPrimaryKey(SalepriceGroup salepriceGroup){
		return salepriceGroupMapper.updateByPrimaryKey(salepriceGroup);
	}



	@Override
	public List<SalepriceGroup> selectByName(String name){
		return salepriceGroupMapper.selectByName(name);
	}



	@Override
	public List<SalepriceGroup> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return salepriceGroupMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return salepriceGroupMapper.selectCount(map);
	}


}
