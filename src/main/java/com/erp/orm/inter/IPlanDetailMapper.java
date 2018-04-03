package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.PlanDetail;

@Repository("planDetailMapper")
public interface IPlanDetailMapper {
    int deleteByPrimaryKey(Integer pdId);

    int insert(PlanDetail planDetail);

    int insertSelective(PlanDetail planDetail);

    PlanDetail selectByPrimaryKey(Integer pdId);

    int updateByPrimaryKeySelective(PlanDetail planDetail);

    int updateByPrimaryKey(PlanDetail planDetail);

	List<PlanDetail> selectByName(String name);

	List<PlanDetail> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}