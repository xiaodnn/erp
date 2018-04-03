package com.erp.service;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.PlanDetail;

@Repository("planDetailService")
public interface IPlanDetailService {
    int delById(Integer pdId);

    int save(PlanDetail planDetail);

    int saveNotNull(PlanDetail planDetail);

    PlanDetail findById(Integer pdId);

    int modifyByIdNotNull(PlanDetail planDetail);

    int modifyById(PlanDetail planDetail);

	List<PlanDetail> findByName(String name);

	List<PlanDetail> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
