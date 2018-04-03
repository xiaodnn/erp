package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.WholesaleApply;
import org.springframework.stereotype.Repository;

@Repository("wholesaleApplyMapper")
public interface IWholesaleApplyMapper {
    int deleteByPrimaryKey(Integer waId);

    int insert(WholesaleApply wholesaleApply);

    int insertSelective(WholesaleApply wholesaleApply);

    WholesaleApply selectByPrimaryKey(Integer waId);

    int updateByPrimaryKeySelective(WholesaleApply wholesaleApply);

    int updateByPrimaryKey(WholesaleApply wholesaleApply);

	WholesaleApply selectByCode(String oCode);

	List<WholesaleApply> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

    List<WholesaleApply> selectByName(String name);
}