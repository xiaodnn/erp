package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.dao.IApproveBillsDao;
import com.erp.orm.entity.ApproveBills;
import com.erp.service.IApproveBillsService;

/**
 * 获取需要审批的单据
 */
@Service("approveBillsService")
public class ApproveBillsServiceImpl implements IApproveBillsService {

    @Resource
    private IApproveBillsDao approveBillsDao;

//    public IApproveBillsDao getApproveBillsDao() {
//        return approveBillsDao;
//    }
//
//    public void setApproveBillsDao(IApproveBillsDao approveBillsDao) {
//        this.approveBillsDao = approveBillsDao;
//    }

    @Override
    public List<ApproveBills> findByEid(Integer eId) {
        return approveBillsDao.selectByEid(eId);
    }
}
