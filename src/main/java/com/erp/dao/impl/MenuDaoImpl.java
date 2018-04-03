/**
 * 
 */
package com.erp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.erp.dao.IMenuDao;
import com.erp.orm.entity.Menu;
import com.erp.orm.inter.IMenuMapper;

/**
 *
 *
 * @author scy
 * @date 2016年2月18日
 */
@Repository("menuDao")
public class MenuDaoImpl implements IMenuDao {

	@Resource
	private IMenuMapper menuMapper;
	
//	/**
//	 * @return the menuMapper
//	 */
//	public IMenuMapper getMenuMapper() {
//		return menuMapper;
//	}
//
//	/**
//	 * @param menuMapper the menuMapper to set
//	 */
//	public void setMenuMapper(IMenuMapper menuMapper) {
//		this.menuMapper = menuMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IMenuDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer mId) {
		return  menuMapper.deleteByPrimaryKey(mId);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IMenuDao#insert(com.erp.orm.entity.Menu)
	 */
	@Override
	public int insert(Menu menu) {
		return menuMapper.insert(menu);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IMenuDao#insertSelective(com.erp.orm.entity.Menu)
	 */
	@Override
	public int insertSelective(Menu menu) {
		return menuMapper.insertSelective(menu);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IMenuDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Menu selectByPrimaryKey(Integer mId) {
		return menuMapper.selectByPrimaryKey(mId);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IMenuDao#selectAll()
	 */
	@Override
	public List<Menu> selectAll() {
		return menuMapper.selectAll();
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IMenuDao#updateByPrimaryKeySelective(com.erp.orm.entity.Menu)
	 */
	@Override
	public int updateByPrimaryKeySelective(Menu menu) {
		return menuMapper.updateByPrimaryKeySelective(menu);
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IMenuDao#updateByPrimaryKey(com.erp.orm.entity.Menu)
	 */
	@Override
	public int updateByPrimaryKey(Menu menu) {
		return menuMapper.updateByPrimaryKey(menu);
	}

}
