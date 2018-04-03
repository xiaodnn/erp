package com.erp.orm.inter;

import com.erp.orm.entity.Organ;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("organMapper")
public interface IOrganMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(Organ record);

    int insertSelective(Organ record);

    Organ selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(Organ record);

    int updateByPrimaryKey(Organ record);

    List<Organ> selectByName(String oName);

    Organ selectByCode(String oCode);

    List<?> selectByPage(Map<String,Integer> map);

    Integer selectCount(Map<String,Object> map);
}