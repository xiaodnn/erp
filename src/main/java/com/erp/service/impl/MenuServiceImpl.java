/**
 * 
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IMenuDao;
import com.erp.orm.entity.Menu;
import com.erp.service.IMenuService;

/**
 *
 *
 * @author scy
 * @date 2016年2月18日
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Resource
	private IMenuDao menuDao;
	
//	/**
//	 * @return the menuDao
//	 */
//	public IMenuDao getMenuDao() {
//		return menuDao;
//	}
//
//	/**
//	 * @param menuDao the menuDao to set
//	 */
//	public void setMenuDao(IMenuDao menuDao) {
//		this.menuDao = menuDao;
//	}

	@Override
	public int deleteByMid(Integer mId) {
		return menuDao.deleteByPrimaryKey(mId);
	}

	@Override
	public int insert(Menu menu) {
		return menuDao.insert(menu);
	}

	@Override
	public int insertSelective(Menu menu) {
		return menuDao.insertSelective(menu);
	}

	@Override
	public Menu selectByPrimaryKey(Integer mId) {
		return menuDao.selectByPrimaryKey(mId);
	}

	@Override
	public List<Menu> selectAll() {
		return menuDao.selectAll();
	}

	@Override
	public int updateByPrimaryKeySelective(Menu menu) {
		return menuDao.updateByPrimaryKeySelective(menu);
	}

	@Override
	public int updateByPrimaryKey(Menu menu) {
		return menuDao.updateByPrimaryKey(menu);
	}

}
