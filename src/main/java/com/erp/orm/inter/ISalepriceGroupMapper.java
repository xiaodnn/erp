package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.SalepriceGroup;

@Repository("salepriceGroupMapper")
public interface ISalepriceGroupMapper {
    int deleteByPrimaryKey(Integer spgId);

    int insert(SalepriceGroup salepriceGroup);

    int insertSelective(SalepriceGroup salepriceGroup);

    SalepriceGroup selectByPrimaryKey(Integer spgId);

    int updateByPrimaryKeySelective(SalepriceGroup salepriceGroup);

    int updateByPrimaryKey(SalepriceGroup salepriceGroup);

	List<SalepriceGroup> selectByName(String name);

	List<SalepriceGroup> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}