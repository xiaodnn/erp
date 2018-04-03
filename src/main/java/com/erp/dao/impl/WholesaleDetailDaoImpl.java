package com.erp.dao.impl;

import com.erp.orm.inter.IWholesaleDetailMapper;
import com.erp.dao.IWholesaleDetailDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.WholesaleDetail;
import org.springframework.stereotype.Repository;

@Repository("wholesaleDetailDao")
public class WholesaleDetailDaoImpl implements  IWholesaleDetailDao {
	@Resource
	private IWholesaleDetailMapper wholesaleDetailMapper;

//	public IWholesaleDetailMapper getWholesaleDetailMapper() {
//		return wholesaleDetailMapper;
//	}
//
//	public void setWholesaleDetailMapper(IWholesaleDetailMapper wholesaleDetailMapper) {
//		this.wholesaleDetailMapper = wholesaleDetailMapper;
//	}

	@Override
	public int deleteByPrimaryKey(Integer wsdId){
		return wholesaleDetailMapper.deleteByPrimaryKey(wsdId);
	}



	@Override
	public int insert(WholesaleDetail wholesaleDetail){
		return wholesaleDetailMapper.insert(wholesaleDetail);
	}



	@Override
	public int insertSelective(WholesaleDetail wholesaleDetail){
		return wholesaleDetailMapper.insertSelective(wholesaleDetail);
	}



	@Override
	public WholesaleDetail selectByPrimaryKey(Integer wsdId){
		return wholesaleDetailMapper.selectByPrimaryKey(wsdId);
	}



	@Override
	public int updateByPrimaryKeySelective(WholesaleDetail wholesaleDetail){
		return wholesaleDetailMapper.updateByPrimaryKeySelective(wholesaleDetail);
	}



	@Override
	public int updateByPrimaryKey(WholesaleDetail wholesaleDetail){
		return wholesaleDetailMapper.updateByPrimaryKey(wholesaleDetail);
	}

	@Override
	public WholesaleDetail selectByCode(String oCode){
		return wholesaleDetailMapper.selectByCode(oCode);
	}



	@Override
	public List<WholesaleDetail> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return wholesaleDetailMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return wholesaleDetailMapper.selectCount(map);
	}

	@Override
	public List<WholesaleDetail> selectByName(String name) {
		return wholesaleDetailMapper.selectByName(name);
	}

	@Override
	public int deleteByWsId(Integer wsId) {
		return wholesaleDetailMapper.deleteByWsId(wsId);
	}

	@Override
	public int deleteByWsIdAndWidAndBatchnoAndSbid(Integer wsId, Integer wId, String batchNo, Integer sbId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("wsId",wsId);
		map.put("wId",wId);
		map.put("batchNo",batchNo);
		map.put("sbId",sbId);
		return wholesaleDetailMapper.deleteByWsIdAndWidAndBatchnoAndSbid(map);
	}


}
