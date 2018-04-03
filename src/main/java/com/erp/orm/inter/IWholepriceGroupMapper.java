package com.erp.orm.inter;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.erp.orm.entity.WholepriceGroup;

@Repository("wholepriceGroupMapper")
public interface IWholepriceGroupMapper {
    int deleteByPrimaryKey(Integer wpgId);

    int insert(WholepriceGroup wholepriceGroup);

    int insertSelective(WholepriceGroup wholepriceGroup);

    WholepriceGroup selectByPrimaryKey(Integer wpgId);

    int updateByPrimaryKeySelective(WholepriceGroup wholepriceGroup);

    int updateByPrimaryKey(WholepriceGroup wholepriceGroup);

    List<WholepriceGroup> selectByName(String name);

	List<WholepriceGroup> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}