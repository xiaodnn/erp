package com.erp.orm.inter;

import com.erp.orm.entity.StorePlace;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("storeplaceMapper")
public interface IStorePlaceMapper {
    int deleteByPrimaryKey(Integer spId);

    int insert(StorePlace record);

    int insertSelective(StorePlace record);

    StorePlace selectByPrimaryKey(Integer spId);

    int updateByPrimaryKeySelective(StorePlace record);

    int updateByPrimaryKey(StorePlace record);

    List<StorePlace> selectByPage(Map<String, Integer> map);

    StorePlace selectByCode(String spCode);

    Integer selectCount(Map<String, Object> map);
}