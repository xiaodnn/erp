package com.erp.orm.inter;

import com.erp.orm.entity.WaresExtend;
import org.springframework.stereotype.Repository;

/**
 * 
 * 商品扩展信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Repository("waresExtendMapper")
public interface IWaresExtendMapper {
	
    int deleteByPrimaryKey(String wId);

    int insert(WaresExtend waresExtend);

    int insertSelective(WaresExtend waresExtend);

    WaresExtend selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(WaresExtend waresExtend);

    int updateByPrimaryKey(WaresExtend waresExtend);
}