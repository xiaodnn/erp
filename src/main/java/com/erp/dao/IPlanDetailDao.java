package com.erp.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.PlanDetail;

@Repository("planDetailDao")
public interface IPlanDetailDao {
    int deleteByPrimaryKey(Integer pdId);

    int insert(PlanDetail planDetail);

    int insertSelective(PlanDetail planDetail);

    PlanDetail selectByPrimaryKey(Integer pdId);

    int updateByPrimaryKeySelective(PlanDetail planDetail);

    int updateByPrimaryKey(PlanDetail planDetail);

	List<PlanDetail> selectByName(String name);

	List<PlanDetail> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
