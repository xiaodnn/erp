/**
 * 
 */
package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.User;

/**
 * 用户
 * @author scy
 *
 */
public interface IUserDao {

	int deleteByPrimaryKey(Integer uId);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();
    
    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User selectByName(String uname);
}
