package com.erp.orm.inter;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.orm.entity.ApproveBills;

@Repository("approveBillsMapper")
public interface IApproveBillsMapper {

    List<ApproveBills> selectByEid(Integer eId);

}