/**
 * 
 */
package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Menu;

/**
 *
 *
 * @author scy
 * @date 2016年2月18日
 */
public interface IMenuDao {

	int deleteByPrimaryKey(Integer mId);

    int insert(Menu menu);

    int insertSelective(Menu menu);

    Menu selectByPrimaryKey(Integer mId);

    List<Menu> selectAll();
    
    int updateByPrimaryKeySelective(Menu menu);

    int updateByPrimaryKey(Menu menu);
    
}
