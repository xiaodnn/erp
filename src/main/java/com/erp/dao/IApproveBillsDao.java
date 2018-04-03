package com.erp.dao;

import com.erp.orm.entity.ApproveBills;

import java.util.List;

public interface IApproveBillsDao {
    List<ApproveBills> selectByEid(Integer eId);
}
