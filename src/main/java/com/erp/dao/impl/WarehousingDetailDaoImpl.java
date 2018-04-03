/**
 * 
 */
package com.erp.dao.impl;

import javax.annotation.Resource;

import com.erp.dao.IWarehousingDetailDao;
import com.erp.orm.entity.WarehousingDetail;
import com.erp.orm.inter.IWarehousingDetailMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 入库信息明细
 *
 * @author scy
 * @date 2017年1月2日
 */
@Repository("warehousingDetailDao")
public class WarehousingDetailDaoImpl implements IWarehousingDetailDao {

	@Resource
	private IWarehousingDetailMapper warehousingDetailMapper;
	
//	/**
//	 * @return the warehousingDetailMapper
//	 */
//	public IWarehousingDetailMapper getWarehousingDetailMapper() {
//		return warehousingDetailMapper;
//	}
//
//	/**
//	 * @param warehousingDetailMapper the warehousingDetailMapper to set
//	 */
//	public void setWarehousingDetailMapper(IWarehousingDetailMapper warehousingDetailMapper) {
//		this.warehousingDetailMapper = warehousingDetailMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDetailDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(String whId,String wId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("whId",whId);
		map.put("wId",wId);

		return warehousingDetailMapper.deleteByPrimaryKey(map) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDetailDao#insert(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int insert(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailMapper.insert(warehousingDetail) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDetailDao#insertSelective(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int insertSelective(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailMapper.insertSelective(warehousingDetail) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDetailDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public WarehousingDetail selectByPrimaryKey(Integer wdId) {
		
		return warehousingDetailMapper.selectByPrimaryKey(wdId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDetailDao#updateByPrimaryKeySelective(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int updateByPrimaryKeySelective(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailMapper.updateByPrimaryKeySelective(warehousingDetail) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDetailDao#updateByPrimaryKey(com.erp.orm.entity.WarehousingDetail)
	 */
	@Override
	public int updateByPrimaryKey(WarehousingDetail warehousingDetail) {
		
		return warehousingDetailMapper.updateByPrimaryKey(warehousingDetail) ;
	}

}
