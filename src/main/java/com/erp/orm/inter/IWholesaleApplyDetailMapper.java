package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.WholesaleApplyDetail;
import org.springframework.stereotype.Repository;

@Repository("wholesaleApplyDetailMapper")
public interface IWholesaleApplyDetailMapper {
    int deleteByPrimaryKey(Integer wadId);

    int insert(WholesaleApplyDetail wholesaleApplyDetail);

    int insertSelective(WholesaleApplyDetail wholesaleApplyDetail);

    WholesaleApplyDetail selectByPrimaryKey(Integer wadId);

    int updateByPrimaryKeySelective(WholesaleApplyDetail wholesaleApplyDetail);

    int updateByPrimaryKey(WholesaleApplyDetail wholesaleApplyDetail);

	WholesaleApplyDetail selectByCode(String oCode);

	List<WholesaleApplyDetail> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

    List<WholesaleApplyDetail> selectByName(String name);

    int deleteByWaIdAndWid(Map<String, String> map);
}