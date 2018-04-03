/**
 * 
 */
package com.erp.dao.impl;

import javax.annotation.Resource;

import com.erp.dao.IParaDao;
import com.erp.orm.entity.Para;
import com.erp.orm.inter.IParaMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * 系统参数
 * @author scy
 * @date 2016年12月6日
 */
@Repository("paraDao")
public class ParaDaoImpl implements IParaDao {

	@Resource
	private IParaMapper paraMapper;
	
//	/**
//	 * @return the paraMapper
//	 */
//	public IParaMapper getParaMapper() {
//		return paraMapper;
//	}
//
//	/**
//	 * @param paraMapper the paraMapper to set
//	 */
//	public void setParaMapper(IParaMapper paraMapper) {
//		this.paraMapper = paraMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IParaDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer pId) {
		
		return paraMapper.deleteByPrimaryKey(pId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IParaDao#insert(com.erp.orm.entity.Para)
	 */
	@Override
	public int insert(Para para) {
		
		return paraMapper.insert(para) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IParaDao#insertSelective(com.erp.orm.entity.Para)
	 */
	@Override
	public int insertSelective(Para para) {
		
		return paraMapper.insertSelective(para) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IParaDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Para selectByPrimaryKey(Integer pId) {
		
		return paraMapper.selectByPrimaryKey(pId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IParaDao#updateByPrimaryKeySelective(com.erp.orm.entity.Para)
	 */
	@Override
	public int updateByPrimaryKeySelective(Para para) {
		
		return paraMapper.updateByPrimaryKeySelective(para) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IParaDao#updateByPrimaryKey(com.erp.orm.entity.Para)
	 */
	@Override
	public int updateByPrimaryKey(Para para) {
		
		return paraMapper.updateByPrimaryKey(para) ;
	}

}
