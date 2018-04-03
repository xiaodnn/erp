/**
 * 
 */
package com.erp.service;

import java.util.List;

import com.erp.orm.entity.User;

/**
 * 用户
 * @author scy
 *
 */
public interface IUserService {

	int delById(Integer uId);

    int save(User user);

    int saveNotNull(User user);

    User findById(Integer uId);

    List<User> findAll();
    
    int modifyByIdNotNull(User user);

    int modifyById(User user);

    User findByName(String uname);
}
