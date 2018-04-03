package com.erp.orm.inter;

import com.erp.orm.entity.Store;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("storeMapper")
public interface IStoreMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Store> selectByPage(Map<String, Integer> map);

    Store selectByCode(String spCode);

    Integer selectCount(Map<String, Object> map);

    int insertOrUpdate(Store store);

    int updateByWid(Store store);

    List<Store> selectByWid(String wId);

    int updateAmountById(Map<String, Object> map);
}