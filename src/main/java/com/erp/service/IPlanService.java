package com.erp.service;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Plan;

@Repository("planService")
public interface IPlanService {
    int delById(Integer pId);

    int save(Plan plan);

    int saveNotNull(Plan plan);

    Plan findById(Integer pId);

    int modifyByIdNotNull(Plan plan);

    int modifyById(Plan plan);

	List<Plan> findByName(String name);

	List<Plan> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
