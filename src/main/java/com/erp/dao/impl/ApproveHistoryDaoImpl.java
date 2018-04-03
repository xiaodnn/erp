package com.erp.dao.impl;

import com.erp.orm.inter.IApproveHistoryMapper;
import com.erp.dao.IApproveHistoryDao;
import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import com.erp.orm.entity.ApproveHistory;
import org.springframework.stereotype.Repository;

@Repository("approveHistoryDao")
public class ApproveHistoryDaoImpl implements  IApproveHistoryDao {
	@Resource
	private IApproveHistoryMapper approveHistoryMapper;

	public IApproveHistoryMapper getApproveHistoryMapper() {
		return approveHistoryMapper;
	}

	public void setApproveHistoryMapper(IApproveHistoryMapper approveHistoryMapper) {
		this.approveHistoryMapper = approveHistoryMapper;
	}

	@Override
	public int deleteByPrimaryKey(Integer ahId){
		return approveHistoryMapper.deleteByPrimaryKey(ahId);
	}



	@Override
	public int insert(ApproveHistory approveHistory){
		return approveHistoryMapper.insert(approveHistory);
	}



	@Override
	public int insertSelective(ApproveHistory approveHistory){
		return approveHistoryMapper.insertSelective(approveHistory);
	}



	@Override
	public ApproveHistory selectByPrimaryKey(Integer ahId){
		return approveHistoryMapper.selectByPrimaryKey(ahId);
	}



	@Override
	public int updateByPrimaryKeySelective(ApproveHistory approveHistory){
		return approveHistoryMapper.updateByPrimaryKeySelective(approveHistory);
	}



	@Override
	public int updateByPrimaryKey(ApproveHistory approveHistory){
		return approveHistoryMapper.updateByPrimaryKey(approveHistory);
	}



	@Override
	public ApproveHistory selectByCode(String oCode){
		return approveHistoryMapper.selectByCode(oCode);
	}



	@Override
	public List<ApproveHistory> selectByPage(Integer page, Integer rows){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return approveHistoryMapper.selectByPage(map);
	}



	@Override
	public Integer selectCount( ){
		Map<String,Object> map = new HashMap<>();
		return approveHistoryMapper.selectCount(map);
	}

	@Override
	public List<ApproveHistory> selectByRid(String rId) {
		return approveHistoryMapper.selectByRid(rId);
	}


}
