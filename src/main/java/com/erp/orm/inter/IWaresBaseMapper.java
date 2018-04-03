package com.erp.orm.inter;

import com.erp.orm.entity.WaresBase;
import org.springframework.stereotype.Repository;

/**
 * 
 * 商品基本信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Repository("waresBaseMapper")
public interface IWaresBaseMapper {
    int deleteByPrimaryKey(String wId);

    int insert(WaresBase waresBase);

    int insertSelective(WaresBase waresBase);

    WaresBase selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(WaresBase waresBase);

    int updateByPrimaryKey(WaresBase waresBase);
}