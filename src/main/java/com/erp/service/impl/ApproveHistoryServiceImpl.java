package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IApproveHistoryDao;
import com.erp.orm.entity.ApproveHistory;
import com.erp.service.IApproveHistoryService;

@Service("approvehistoryService")
public class ApproveHistoryServiceImpl implements  IApproveHistoryService {
	@Resource
	private IApproveHistoryDao approveHistoryDao;

//	public IApproveHistoryDao getApproveHistoryDao() {
//		return approveHistoryDao;
//	}
//
//	public void setApproveHistoryDao(IApproveHistoryDao approveHistoryDao) {
//		this.approveHistoryDao = approveHistoryDao;
//	}

	@Override
	public int delById(Integer ahId){
		return approveHistoryDao.deleteByPrimaryKey(ahId);
	}



	@Override
	public int save(ApproveHistory approveHistory){
		return approveHistoryDao.insert(approveHistory);
	}



	@Override
	public int saveNotNull(ApproveHistory approveHistory){
		return approveHistoryDao.insertSelective(approveHistory);
	}



	@Override
	public ApproveHistory findById(Integer ahId){
		return approveHistoryDao.selectByPrimaryKey(ahId);
	}



	@Override
	public int modifyByIdNotNull(ApproveHistory approveHistory){
		return approveHistoryDao.updateByPrimaryKeySelective(approveHistory);
	}



	@Override
	public int modifyById(ApproveHistory approveHistory){
		return approveHistoryDao.updateByPrimaryKey(approveHistory);
	}



	@Override
	public ApproveHistory findByCode(String oCode){
		return approveHistoryDao.selectByCode(oCode);
	}



	@Override
	public List<ApproveHistory> findByPage(Integer page, Integer rows){
		return approveHistoryDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return approveHistoryDao.selectCount();
	}

	@Override
	public List<ApproveHistory> findByRid(String rId) {
		return approveHistoryDao.selectByRid(rId);
	}


}
