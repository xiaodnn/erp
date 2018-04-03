package com.erp.service;

import com.erp.orm.entity.ApproveBills;

import java.util.List;

public interface IApproveBillsService {
    List<ApproveBills> findByEid(Integer eId);
}
