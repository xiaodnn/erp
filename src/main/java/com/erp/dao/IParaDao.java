/**
 * 
 */
package com.erp.dao;

import com.erp.orm.entity.Para;

/**
 *
 * 系统参数
 * @author scy
 * @date 2016年12月6日
 */
public interface IParaDao {

	int deleteByPrimaryKey(Integer pId);

    int insert(Para para);

    int insertSelective(Para para);

    Para selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Para para);

    int updateByPrimaryKey(Para para);
}
