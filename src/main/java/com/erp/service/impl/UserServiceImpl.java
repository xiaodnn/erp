/**
 * 
 */
package com.erp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erp.dao.IUserDao;
import com.erp.orm.entity.User;
import com.erp.service.IUserService;

import javax.annotation.Resource;

/**
 * @author scy
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

//	public IUserDao getUserDao() {
//		return userDao;
//	}
//
//	public void setUserDao(IUserDao userDao) {
//		this.userDao = userDao;
//	}

	/* (non-Javadoc)
	 * @see com.erp.service.IUserService#delById(java.lang.Integer)
	 */
	@Override
	public int delById(Integer uId) {
		
		return userDao.deleteByPrimaryKey(uId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IUserService#save(com.erp.orm.entity.User)
	 */
	@Override
	public int save(User user) {
		
		return userDao.insert(user) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IUserService#saveNotNull(com.erp.orm.entity.User)
	 */
	@Override
	public int saveNotNull(User user) {
		
		return userDao.insertSelective(user) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IUserService#findById(java.lang.Integer)
	 */
	@Override
	public User findById(Integer uId) {
		
		return userDao.selectByPrimaryKey(uId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IUserService#findAll()
	 */
	@Override
	public List<User> findAll() {
		
		return userDao.selectAll() ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IUserService#modifyByIdNotNull(com.erp.orm.entity.User)
	 */
	@Override
	public int modifyByIdNotNull(User user) {
		
		return userDao.updateByPrimaryKeySelective(user) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.service.IUserService#modifyById(com.erp.orm.entity.User)
	 */
	@Override
	public int modifyById(User user) {
		
		return userDao.updateByPrimaryKey(user) ;
	}

	@Override
	public User findByName(String uname) {
		return userDao.selectByName(uname);
	}

}
