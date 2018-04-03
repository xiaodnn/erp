package com.erp.dao.impl;

import com.erp.dao.IApproveBillsDao;
import com.erp.orm.entity.ApproveBills;
import com.erp.orm.inter.IApproveBillsMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("approveBillsDao")
public class ApproveBillsDaoImpl implements IApproveBillsDao {
    @Resource
    private IApproveBillsMapper approveBillsMapper;

//    public ApproveBillsDaoImpl(){
//        //设置命名空间
//        super.setNs("com.erp.orm.inter.IApproveBillsMapper");
//    }

//    public IApproveBillsMapper getApproveBillsMapper() {
//        return approveBillsMapper;
//    }
//
//    public void setApproveBillsMapper(IApproveBillsMapper approveBillsMapper) {
//        this.approveBillsMapper = approveBillsMapper;
//    }

    @Override
    public List<ApproveBills> selectByEid(Integer eId) {
        return approveBillsMapper.selectByEid(eId);
    }
}
