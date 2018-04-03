/**
 * 
 */
package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Warehousing;

/**
 * 入库信息
 *
 * @author scy
 * @date 2017年1月2日
 */
public interface IWarehousingDao {

	int deleteByPrimaryKey(String whId);

    int insert(Warehousing warehousing);

    int insertSelective(Warehousing warehousing);

    Warehousing selectByPrimaryKey(String whId);

    int updateByPrimaryKeySelective(Warehousing warehousing);

    int updateByPrimaryKey(Warehousing warehousing);

	List<Warehousing> selectByIdOrTimeOrCreator(String whId, String whInitime, String whCreator);
    
	List<Warehousing> selectAll();

    List<Warehousing> selectByPage(Integer page, Integer rows);

    Integer selectCount();
}
