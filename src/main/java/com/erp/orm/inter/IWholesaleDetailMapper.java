package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.WholesaleDetail;
import org.springframework.stereotype.Repository;

@Repository("wholesaleDetailMapper")
public interface IWholesaleDetailMapper {
    int deleteByPrimaryKey(Integer wsdId);

    int insert(WholesaleDetail wholesaleDetail);

    int insertSelective(WholesaleDetail wholesaleDetail);

    WholesaleDetail selectByPrimaryKey(Integer wsdId);

    int updateByPrimaryKeySelective(WholesaleDetail wholesaleDetail);

    int updateByPrimaryKey(WholesaleDetail wholesaleDetail);

	WholesaleDetail selectByCode(String oCode);

	List<WholesaleDetail> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

    List<WholesaleDetail> selectByName(String name);

    int deleteByWsId(Integer wsId);

    int deleteByWsIdAndWidAndBatchnoAndSbid(Map<String, Object> map);
}