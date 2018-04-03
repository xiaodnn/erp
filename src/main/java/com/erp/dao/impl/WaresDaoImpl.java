/**
 * 
 */
package com.erp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.erp.dao.IWaresDao;
import com.erp.orm.entity.Wares;
import com.erp.orm.inter.IWaresMapper;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author scy
 * @date 2016年9月29日
 */
@Repository("waresDao")
public class WaresDaoImpl implements IWaresDao {

	@Resource
	private IWaresMapper waresMapper;
	
	/**
//	 * @return the waresMapper
//	 */
//	public IWaresMapper getWaresMapper() {
//		return waresMapper;
//	}
//
//	/**
//	 * @param waresMapper the waresMapper to set
//	 */
//	public void setWaresMapper(IWaresMapper waresMapper) {
//		this.waresMapper = waresMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String wId) {
		return waresMapper.deleteByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresDao#insert(com.erp.orm.entity.Wares)
	 */
	@Override
	public int insert(Wares wares) {
		
		return waresMapper.insert(wares) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresDao#insertSelective(com.erp.orm.entity.Wares)
	 */
	@Override
	public int insertSelective(Wares wares) {
		
		return waresMapper.insertSelective(wares) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Wares selectByPrimaryKey(String wId) {
		
		return waresMapper.selectByPrimaryKey(wId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresDao#updateByPrimaryKeySelective(com.erp.orm.entity.Wares)
	 */
	@Override
	public int updateByPrimaryKeySelective(Wares wares) {
		
		return waresMapper.updateByPrimaryKeySelective(wares) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IWaresDao#updateByPrimaryKey(com.erp.orm.entity.Wares)
	 */
	@Override
	public int updateByPrimaryKey(Wares wares) {
		
		return waresMapper.updateByPrimaryKey(wares) ;
	}

	@Override
	public List<Wares> selectAll() {
		return waresMapper.selectAll();
	}

	@Override
	public List<Wares> selectByName(String wTraname) {
		//根据商品名称获取商品信息
		return waresMapper.selectByName(wTraname);
	}

	@Override
	public List<Wares> selectByNameOrId(String s) {
		return waresMapper.selectByNameOrId(s);
	}

	@Override
	public List<Wares> selectByZjmOrId(String zjm) {
		return waresMapper.selectByZjmOrId(zjm);
	}
	@Override
	public List<Wares> selectByPage(Integer page, Integer rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageStart",page*rows);
		map.put("pageSize",rows);
		return waresMapper.selectByPage(map);
	}

	@Override
	public Integer selectCount() {
		Map<String,Object> map = new HashMap<>();
		return waresMapper.selectCount(map);
	}

}
