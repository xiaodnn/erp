package com.erp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.orm.entity.WaresSalepriceGroup;
import com.erp.orm.entity.WaresSalepriceGroupKey;

@Repository("waresSalepriceGroupDao")
public interface IWaresSalepriceGroupDao {
    int deleteByPrimaryKey(WaresSalepriceGroupKey key);

    int insert(WaresSalepriceGroup waresSalepriceGroup);

    int insertSelective(WaresSalepriceGroup waresSalepriceGroup);

    WaresSalepriceGroup selectByPrimaryKey(WaresSalepriceGroupKey key);

    int updateByPrimaryKeySelective(WaresSalepriceGroup waresSalepriceGroup);

    int updateByPrimaryKey(WaresSalepriceGroup waresSalepriceGroup);

	List<WaresSalepriceGroup> selectByName(String name);

	List<WaresSalepriceGroup> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
