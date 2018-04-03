package com.erp.dao.impl;

import com.erp.orm.inter.IWholesaleApplyDetailMapper;
import com.erp.dao.IWholesaleApplyDetailDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.WholesaleApplyDetail;
import org.springframework.stereotype.Repository;

@Repository("wholesaleApplyDetailDao")
public class WholesaleApplyDetailDaoImpl implements  IWholesaleApplyDetailDao {
	@Resource
	private IWholesaleApplyDetailMapper wholesaleApplyDetailMapper;

//	public IWholesaleApplyDetailMapper getWholesaleApplyDetailMapper() {
//		return wholesaleApplyDetailMapper;
//	}
//
//	public void setWholesaleApplyDetailMapper(IWholesaleApplyDetailMapper wholesaleApplyDetailMapper) {
//		this.wholesaleApplyDetailMapper = wholesaleApplyDetailMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer wadId){
		return wholesaleApplyDetailMapper.deleteByPrimaryKey(wadId);
	}



	@Override
	public int insert(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailMapper.insert(wholesaleApplyDetail);
	}



	@Override
	public int insertSelective(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailMapper.insertSelective(wholesaleApplyDetail);
	}



	@Override
	public WholesaleApplyDetail selectByPrimaryKey(Integer wadId){
		return wholesaleApplyDetailMapper.selectByPrimaryKey(wadId);
	}



	@Override
	public int updateByPrimaryKeySelective(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailMapper.updateByPrimaryKeySelective(wholesaleApplyDetail);
	}



	@Override
	public int updateByPrimaryKey(WholesaleApplyDetail wholesaleApplyDetail){
		return wholesaleApplyDetailMapper.updateByPrimaryKey(wholesaleApplyDetail);
	}



	@Override
	public WholesaleApplyDetail selectByCode(String oCode){
		return wholesaleApplyDetailMapper.selectByCode(oCode);
	}



	@Override
	public List<WholesaleApplyDetail> selectByPage(Integer page, Integer rows,Integer waId){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		map.put("waId",waId);
		return wholesaleApplyDetailMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return wholesaleApplyDetailMapper.selectCount(map);
	}

	@Override
	public List<WholesaleApplyDetail> selectByName(String name) {
		return wholesaleApplyDetailMapper.selectByName(name);
	}

	@Override
	public int deleteByWaIdAndWid(String waId, String wId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("waId",waId);
		map.put("wId",wId);
		return wholesaleApplyDetailMapper.deleteByWaIdAndWid(map);
	}


}
