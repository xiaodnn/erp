package com.erp.orm.inter;

import com.erp.orm.entity.StoreBatch;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("storeBatchMapper")
public interface IStoreBatchMapper {
    int deleteByPrimaryKey(Integer sbId);

    int insert(StoreBatch record);

    int insertSelective(StoreBatch record);

    StoreBatch selectByPrimaryKey(Integer sbId);

    int updateByPrimaryKeySelective(StoreBatch record);

    int updateByPrimaryKey(StoreBatch record);

    StoreBatch selectByCode(String batch_num);

    List<StoreBatch> selectByPage(Map<String,Integer> map);

    Integer selectCount(Map<String,Object> map);

    int updateAmountById(Map<String, Object> map);
}