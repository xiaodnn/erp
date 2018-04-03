package com.erp.orm.inter;

import java.util.List;

import com.erp.orm.entity.User;
import org.springframework.stereotype.Repository;

@Repository(value="userMapper")
public interface IUserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();
    
    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User selectByName(String uname);
}