package com.erp.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Plan;

@Repository("planDao")
public interface IPlanDao {
    int deleteByPrimaryKey(Integer pId);

    int insert(Plan plan);

    int insertSelective(Plan plan);

    Plan selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Plan plan);

    int updateByPrimaryKey(Plan plan);

	List<Plan> selectByName(String name);

	List<Plan> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
