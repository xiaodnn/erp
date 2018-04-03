package com.erp.orm.inter;

import com.erp.orm.entity.StoreHouse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("storehouseMapper")
public interface IStoreHouseMapper {
    int deleteByPrimaryKey(Integer shId);

    int insert(StoreHouse record);

    int insertSelective(StoreHouse record);

    StoreHouse selectByPrimaryKey(Integer shId);

    List<StoreHouse> selectAll();

    int updateByPrimaryKeySelective(StoreHouse record);

    int updateByPrimaryKey(StoreHouse record);

    StoreHouse selectByCode(String shCode);

    Integer selectCount(Map<String, Object> map);

    List<StoreHouse> selectByPage(Map<String, Integer> map);
}