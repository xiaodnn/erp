package com.erp.orm.inter;

import com.erp.orm.entity.StoreZone;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("storeZoneMapper")
public interface IStoreZoneMapper {
    int deleteByPrimaryKey(Integer szId);

    int insert(StoreZone record);

    int insertSelective(StoreZone record);

    StoreZone selectByPrimaryKey(Integer szId);

    int updateByPrimaryKeySelective(StoreZone record);

    int updateByPrimaryKey(StoreZone record);

    List<StoreZone> selectByPage(Map<String,Integer> map);

    Integer selectCount(Map<String,Object> map);

    StoreZone selectByCode(String szCode);
}