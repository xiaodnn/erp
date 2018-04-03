package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Plan;

@Repository("planMapper")
public interface IPlanMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Plan plan);

    int insertSelective(Plan plan);

    Plan selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Plan plan);

    int updateByPrimaryKey(Plan plan);

	List<Plan> selectByName(String name);

	List<Plan> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}