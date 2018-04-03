/**
 * 
 */
package com.erp.dao.impl;

import javax.annotation.Resource;

import com.erp.dao.IWaresExtendDao;
import com.erp.orm.entity.WaresExtend;
import com.erp.orm.inter.IWaresExtendMapper;
import org.springframework.stereotype.Repository;

/**
 * 商品扩展信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Repository("waresExtendDao")
public class WaresExtendDaoImpl implements IWaresExtendDao {
	
	@Resource
	private IWaresExtendMapper waresExtendMapper;
//	/**
//	 * @return the waresExtendMapper
//	 */
//	public IWaresExtendMapper getWaresExtendMapper() {
//		return waresExtendMapper;
//	}
//
//	/**
//	 * @param waresExtendMapper the waresExtendMapper to set
//	 */
//	public void setWaresExtendMapper(IWaresExtendMapper waresExtendMapper) {
//		this.waresExtendMapper = waresExtendMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresExtendDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String wId) {
		
		return waresExtendMapper.deleteByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresExtendDao#insert(com.erp.orm.entity.WaresExtend)
	 */
	@Override
	public int insert(WaresExtend waresExtend) {
		
		return waresExtendMapper.insert(waresExtend) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresExtendDao#insertSelective(com.erp.orm.entity.WaresExtend)
	 */
	@Override
	public int insertSelective(WaresExtend waresExtend) {
		
		return waresExtendMapper.insertSelective(waresExtend) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresExtendDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public WaresExtend selectByPrimaryKey(String wId) {
		
		return waresExtendMapper.selectByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresExtendDao#updateByPrimaryKeySelective(com.erp.orm.entity.WaresExtend)
	 */
	@Override
	public int updateByPrimaryKeySelective(WaresExtend waresExtend) {
		
		return waresExtendMapper.updateByPrimaryKeySelective(waresExtend) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresExtendDao#updateByPrimaryKey(com.erp.orm.entity.WaresExtend)
	 */
	@Override
	public int updateByPrimaryKey(WaresExtend waresExtend) {
		
		return waresExtendMapper.updateByPrimaryKey(waresExtend) ;
	}

}
