/**
 * 
 */
package com.erp.dao.impl;

import javax.annotation.Resource;

import com.erp.dao.IWaresPriceDao;
import com.erp.orm.entity.WaresPrice;
import com.erp.orm.inter.IWaresPriceMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品价格信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Repository("waresPriceDao")
public class WaresPriceDaoImpl implements IWaresPriceDao {

	@Resource
	private IWaresPriceMapper waresPriceMapper;
	
//	/**
//	 * @return the waresPriceMapper
//	 */
//	public IWaresPriceMapper getWaresPriceMapper() {
//		return waresPriceMapper;
//	}
//
//	/**
//	 * @param waresPriceMapper the waresPriceMapper to set
//	 */
//	public void setWaresPriceMapper(IWaresPriceMapper waresPriceMapper) {
//		this.waresPriceMapper = waresPriceMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresPriceDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String wId) {
		
		return waresPriceMapper.deleteByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresPriceDao#insert(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int insert(WaresPrice waresPrice) {
		
		return waresPriceMapper.insert(waresPrice) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresPriceDao#insertSelective(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int insertSelective(WaresPrice waresPrice) {
		
		return waresPriceMapper.insertSelective(waresPrice) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresPriceDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public WaresPrice selectByPrimaryKey(String wId) {
		
		return waresPriceMapper.selectByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresPriceDao#updateByPrimaryKeySelective(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int updateByPrimaryKeySelective(WaresPrice waresPrice) {
		
		return waresPriceMapper.updateByPrimaryKeySelective(waresPrice) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresPriceDao#updateByPrimaryKey(com.erp.orm.entity.WaresPrice)
	 */
	@Override
	public int updateByPrimaryKey(WaresPrice waresPrice) {
		
		return waresPriceMapper.updateByPrimaryKey(waresPrice) ;
	}

	@Override
	public int updateByWid(String wid, Float wCostprice, Float wSaleprice) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("wid",wid);
		map.put("wCostprice",wCostprice);
		map.put("wSaleprice",wSaleprice);

		return waresPriceMapper.updateByWid(map);
	}

	@Override
	public int insertOrUpdate(WaresPrice waresPrice) {
		return waresPriceMapper.insertOrUpdate(waresPrice);
	}

}
