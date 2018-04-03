package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.WaresSalepriceGroup;
import com.erp.orm.entity.WaresSalepriceGroupKey;

@Repository("waresSalepriceGroupMapper")
public interface IWaresSalepriceGroupMapper {
    int deleteByPrimaryKey(WaresSalepriceGroupKey key);

    int insert(WaresSalepriceGroup waresSalepriceGroup);

    int insertSelective(WaresSalepriceGroup waresSalepriceGroup);

    WaresSalepriceGroup selectByPrimaryKey(WaresSalepriceGroupKey key);

    int updateByPrimaryKeySelective(WaresSalepriceGroup waresSalepriceGroup);

    int updateByPrimaryKey(WaresSalepriceGroup waresSalepriceGroup);

	List<WaresSalepriceGroup> selectByName(String name);

	List<WaresSalepriceGroup> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}