package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.Wholesale;
import org.springframework.stereotype.Repository;

@Repository("wholesaleMapper")
public interface IWholesaleMapper {
    int deleteByPrimaryKey(Integer wsId);

    int insert(Wholesale wholesale);

    int insertSelective(Wholesale wholesale);

    Wholesale selectByPrimaryKey(Integer wsId);

    int updateByPrimaryKeySelective(Wholesale wholesale);

    int updateByPrimaryKey(Wholesale wholesale);

	Wholesale selectByCode(String oCode);

	List<Wholesale> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

    List<Wholesale> selectByName(String name);
}