/**
 * 
 */
package com.erp.dao;

import com.erp.orm.entity.WaresExtend;

/**
 * 商品扩展信息
 *
 * @author scy
 * @date 2016年12月14日
 */
public interface IWaresExtendDao {

	int deleteByPrimaryKey(String wId);

    int insert(WaresExtend waresExtend);

    int insertSelective(WaresExtend waresExtend);

    WaresExtend selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(WaresExtend waresExtend);

    int updateByPrimaryKey(WaresExtend waresExtend);
    
}
