package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.WaresWholepriceGroup;
import com.erp.orm.entity.WaresWholepriceGroupKey;

@Repository("waresWholepriceGroupMapper")
public interface IWaresWholepriceGroupMapper {
    int deleteByPrimaryKey(WaresWholepriceGroupKey key);

    int insert(WaresWholepriceGroup waresWholepriceGroup);

    int insertSelective(WaresWholepriceGroup waresWholepriceGroup);

    WaresWholepriceGroup selectByPrimaryKey(WaresWholepriceGroupKey key);

    int updateByPrimaryKeySelective(WaresWholepriceGroup waresWholepriceGroup);

    int updateByPrimaryKey(WaresWholepriceGroup waresWholepriceGroup);

	List<WaresWholepriceGroup> selectByName(String name);

	List<WaresWholepriceGroup> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}