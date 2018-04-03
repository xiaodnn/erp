/**
 * 
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IApproveDao;
import com.erp.orm.entity.Approve;
import com.erp.service.IApproveService;

/**
 * @author scy
 *
 */
@Service("approveService")
public class ApproveServiceImpl implements IApproveService {

	@Resource
	private IApproveDao approveDao;
	
//	public IApproveDao getApproveDao() {
//		return approveDao;
//	}
//
//	public void setApproveDao(IApproveDao approveDao) {
//		this.approveDao = approveDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.IApproveService#delById(java.lang.Integer)
	 */
	@Override
	public int delById(Integer aId) {
		
		return approveDao.deleteByPrimaryKey(aId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IApproveService#save(com.erp.orm.entity.Approve)
	 */
	@Override
	public int save(Approve approve) {
		
		return approveDao.insert(approve) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IApproveService#saveNotNull(com.erp.orm.entity.Approve)
	 */
	@Override
	public int saveNotNull(Approve approve) {
		
		return approveDao.insertSelective(approve) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IApproveService#findById(java.lang.Integer)
	 */
	@Override
	public Approve findById(Integer aId) {
		
		return approveDao.selectByPrimaryKey(aId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IApproveService#findByOgranAndModule(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Approve findByOgranAndModule(Integer organ, Integer module) {
		
		return approveDao.selectByOgranAndModule(organ, module) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IApproveService#modifyByIdNotNull(com.erp.orm.entity.Approve)
	 */
	@Override
	public int modifyByIdNotNull(Approve approve) {
		
		return approveDao.updateByPrimaryKeySelective(approve) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IApproveService#modifyById(com.erp.orm.entity.Approve)
	 */
	@Override
	public int modifyById(Approve approve) {
		
		return approveDao.updateByPrimaryKey(approve) ;
	}

	@Override
	public Approve findByOrder(Integer uid, Integer organ, Integer module) {
		return approveDao.selectByOrder(uid,organ,module);
	}

	/**
	 * 根据模块ID,查询需审批部门和人员信息
	 * @param mId
	 * @return
	 */
	@Override
	public Approve findByMid(Integer mId) {
		return approveDao.selectByMid(mId);
	}

	@Override
	public List<Approve> findAll() {
		return approveDao.selectAll();
	}

	@Override
	public List<Approve> findByPage(Integer page, Integer rows) {
		return approveDao.selectByPage(page,rows);
	}

	@Override
	public Integer findCount() {
		return approveDao.selectCount();
	}

}
