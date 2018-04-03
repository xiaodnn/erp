/**
 * 
 */
package com.erp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.erp.dao.IUserDao;
import com.erp.orm.entity.User;
import com.erp.orm.inter.IUserMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户
 * @author scy
 *
 */
@Repository(value="userDao")
public class UserDaoImpl implements IUserDao {

	@Resource
	private IUserMapper userMapper;
	
//	public IUserMapper getUserMapper() {
//		return userMapper;
//	}
//
//	public void setUserMapper(IUserMapper userMapper) {
//		this.userMapper = userMapper;
//	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IUserDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer uId) {
		
		return userMapper.deleteByPrimaryKey(uId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IUserDao#insert(com.erp.orm.entity.User)
	 */
	@Override
	public int insert(User user) {
		
		return userMapper.insert(user) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IUserDao#insertSelective(com.erp.orm.entity.User)
	 */
	@Override
	public int insertSelective(User user) {
		
		return userMapper.insertSelective(user) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IUserDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public User selectByPrimaryKey(Integer uId) {
		
		return userMapper.selectByPrimaryKey(uId) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IUserDao#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		
		return userMapper.selectAll();
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IUserDao#updateByPrimaryKeySelective(com.erp.orm.entity.User)
	 */
	@Override
	public int updateByPrimaryKeySelective(User user) {
		
		return userMapper.updateByPrimaryKeySelective(user) ;
	}

	/* (non-Javadoc)
	 * @see com.erp.dao.IUserDao#updateByPrimaryKey(com.erp.orm.entity.User)
	 */
	@Override
	public int updateByPrimaryKey(User user) {
		
		return userMapper.updateByPrimaryKey(user) ;
	}

	@Override
	public User selectByName(String uname) {
		return userMapper.selectByName(uname);
	}

}
