/**
 * 
 */
package com.erp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.erp.dao.IApproveDao;
import com.erp.orm.entity.Approve;
import com.erp.orm.inter.IApproveMapper;
import org.springframework.stereotype.Repository;

/**
 * 审核流程设置
 * @author scy
 *
 */
@Repository("approveDao")
public class ApproveDaoImpl implements IApproveDao {

	@Resource
	private IApproveMapper approveMapper;
	
//	public IApproveMapper getApproveMapper() {
//		return approveMapper;
//	}
//
//	public void setApproveMapper(IApproveMapper approveMapper) {
//		this.approveMapper = approveMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IApproveDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer aId) {
		
		return approveMapper.deleteByPrimaryKey(aId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IApproveDao#insert(com.erp.orm.entity.Approve)
	 */
	@Override
	public int insert(Approve approve) {
		
		return approveMapper.insert(approve) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IApproveDao#insertSelective(com.erp.orm.entity.Approve)
	 */
	@Override
	public int insertSelective(Approve approve) {
		
		return approveMapper.insertSelective(approve) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IApproveDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Approve selectByPrimaryKey(Integer aId) {
		
		return approveMapper.selectByPrimaryKey(aId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IApproveDao#selectByOgranAndModule(java.util.Map)
	 */
	@Override
	public Approve selectByOgranAndModule(Integer organ,Integer module) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("organ", organ);
		map.put("module", module);
		return approveMapper.selectByOgranAndModule(map) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IApproveDao#updateByPrimaryKeySelective(com.erp.orm.entity.Approve)
	 */
	@Override
	public int updateByPrimaryKeySelective(Approve approve) {
		
		return approveMapper.updateByPrimaryKeySelective(approve) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IApproveDao#updateByPrimaryKey(com.erp.orm.entity.Approve)
	 */
	@Override
	public int updateByPrimaryKey(Approve approve) {
		
		return approveMapper.updateByPrimaryKey(approve) ;
	}

	@Override
	public Approve selectByOrder(Integer uid, Integer organ, Integer module) {
		Map<String, Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("organ", organ);
		map.put("module", module);
		return approveMapper.selectByOrder(map);
	}

	/**
	 * 根据模块ID,查询需审批部门和人员信息
	 * @param mId
	 * @return
	 */
	@Override
	public Approve selectByMid(Integer mId) {
		return approveMapper.selectByMid(mId);
	}

	@Override
	public List<Approve> selectAll() {
		return approveMapper.selectAll();
	}

	@Override
	public List<Approve> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return approveMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return approveMapper.selectCount(map);
	}

}
