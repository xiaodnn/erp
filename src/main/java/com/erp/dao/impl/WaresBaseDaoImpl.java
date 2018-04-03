/**
 * 
 */
package com.erp.dao.impl;

import javax.annotation.Resource;

import com.erp.dao.IWaresBaseDao;
import com.erp.orm.entity.WaresBase;
import com.erp.orm.inter.IWaresBaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 商品基本信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Repository("waresBaseDao")
public class WaresBaseDaoImpl implements IWaresBaseDao {
	
	@Resource
	private IWaresBaseMapper waresBaseMapper;

//	/**
//	 * @return the waresBaseMapper
//	 */
//	public IWaresBaseMapper getWaresBaseMapper() {
//		return waresBaseMapper;
//	}
//
//	/**
//	 * @param waresBaseMapper the waresBaseMapper to set
//	 */
//	public void setWaresBaseMapper(IWaresBaseMapper waresBaseMapper) {
//		this.waresBaseMapper = waresBaseMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresBaseDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String wId) {
		
		return waresBaseMapper.deleteByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresBaseDao#insert(com.erp.orm.entity.WaresBase)
	 */
	@Override
	public int insert(WaresBase waresBase) {
		
		return waresBaseMapper.insert(waresBase) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresBaseDao#insertSelective(com.erp.orm.entity.WaresBase)
	 */
	@Override
	public int insertSelective(WaresBase waresBase) {
		
		return waresBaseMapper.insertSelective(waresBase) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresBaseDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public WaresBase selectByPrimaryKey(String wId) {
		
		return waresBaseMapper.selectByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresBaseDao#updateByPrimaryKeySelective(com.erp.orm.entity.WaresBase)
	 */
	@Override
	public int updateByPrimaryKeySelective(WaresBase waresBase) {
		
		return waresBaseMapper.updateByPrimaryKeySelective(waresBase) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresBaseDao#updateByPrimaryKey(com.erp.orm.entity.WaresBase)
	 */
	@Override
	public int updateByPrimaryKey(WaresBase waresBase) {
		
		return waresBaseMapper.updateByPrimaryKey(waresBase) ;
	}

}
