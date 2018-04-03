package com.erp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.orm.entity.WaresWholepriceGroup;
import com.erp.orm.entity.WaresWholepriceGroupKey;

@Repository("waresWholepriceGroupDao")
public interface IWaresWholepriceGroupDao {
    int deleteByPrimaryKey(WaresWholepriceGroupKey key);

    int insert(WaresWholepriceGroup waresWholepriceGroup);

    int insertSelective(WaresWholepriceGroup waresWholepriceGroup);

    WaresWholepriceGroup selectByPrimaryKey(WaresWholepriceGroupKey key);

    int updateByPrimaryKeySelective(WaresWholepriceGroup waresWholepriceGroup);

    int updateByPrimaryKey(WaresWholepriceGroup waresWholepriceGroup);

	List<WaresWholepriceGroup> selectByName(String name);

	List<WaresWholepriceGroup> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
