package com.erp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.orm.entity.SalepriceGroup;

@Repository("salepriceGroupDao")
public interface ISalepriceGroupDao {
    int deleteByPrimaryKey(Integer spgId);

    int insert(SalepriceGroup salepriceGroup);

    int insertSelective(SalepriceGroup salepriceGroup);

    SalepriceGroup selectByPrimaryKey(Integer spgId);

    int updateByPrimaryKeySelective(SalepriceGroup salepriceGroup);

    int updateByPrimaryKey(SalepriceGroup salepriceGroup);

	List<SalepriceGroup> selectByName(String name);

	List<SalepriceGroup> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
