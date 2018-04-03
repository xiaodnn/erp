package com.erp.orm.inter;

import com.erp.orm.entity.StoreDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("storeDetailMapper")
public interface IStoreDetailMapper {
    int deleteByPrimaryKey(Integer sdId);

    int insert(StoreDetail record);

    int insertSelective(StoreDetail record);

    StoreDetail selectByPrimaryKey(Integer sdId);

    int updateByPrimaryKeySelective(StoreDetail record);

    int updateByPrimaryKey(StoreDetail record);

    StoreDetail selectByCode(String oCode);

    List<StoreDetail> selectByPage(Map<String,Integer> map);

    Integer selectCount(Map<String,Object> map);

    List<StoreDetail> selectBySid(Integer sId);

    int updateAmountById(Map<String, Object> map);
}