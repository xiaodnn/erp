/**
 * 
 */
package com.erp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.erp.dao.IWarehousingDao;
import com.erp.orm.entity.Warehousing;
import com.erp.orm.inter.IWarehousingMapper;
import org.springframework.stereotype.Repository;

/**
 * 入库信息
 *
 * @author scy
 * @date 2017年1月2日
 */
@Repository("warehousingDao")
public class WarehousingDaoImpl implements IWarehousingDao {
	
	@Resource
	private IWarehousingMapper warehousingMapper;

//	/**
//	 * @return the warehousingMapper
//	 */
//	public IWarehousingMapper getWarehousingMapper() {
//		return warehousingMapper;
//	}
//
//	/**
//	 * @param warehousingMapper the warehousingMapper to set
//	 */
//	public void setWarehousingMapper(IWarehousingMapper warehousingMapper) {
//		this.warehousingMapper = warehousingMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String whId) {
		
		return warehousingMapper.deleteByPrimaryKey(whId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDao#insert(com.erp.orm.entity.Warehousing)
	 */
	@Override
	public int insert(Warehousing warehousing) {
		
		return warehousingMapper.insert(warehousing) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDao#insertSelective(com.erp.orm.entity.Warehousing)
	 */
	@Override
	public int insertSelective(Warehousing warehousing) {
		
		return warehousingMapper.insertSelective(warehousing) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Warehousing selectByPrimaryKey(String whId) {
		
		return warehousingMapper.selectByPrimaryKey(whId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDao#updateByPrimaryKeySelective(com.erp.orm.entity.Warehousing)
	 */
	@Override
	public int updateByPrimaryKeySelective(Warehousing warehousing) {
		
		return warehousingMapper.updateByPrimaryKeySelective(warehousing) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWarehousingDao#updateByPrimaryKey(com.erp.orm.entity.Warehousing)
	 */
	@Override
	public int updateByPrimaryKey(Warehousing warehousing) {
		
		return warehousingMapper.updateByPrimaryKey(warehousing) ;
	}

	@Override
	public List<Warehousing> selectByIdOrTimeOrCreator(String whId, String whInitime, String whCreator) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("whId", whId);
		map.put("whInitime", whInitime);
		map.put("whCreator", whCreator);
		return warehousingMapper.selectByIdOrTimeOrCreator(map);
	}

	@Override
	public List<Warehousing> selectAll() {
		return warehousingMapper.selectAll();
	}

	@Override
	public List<Warehousing> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return warehousingMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return warehousingMapper.selectCount(map);
	}

}
