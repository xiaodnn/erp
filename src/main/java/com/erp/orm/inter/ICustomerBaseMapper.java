package com.erp.orm.inter;

import com.erp.orm.entity.CustomerBase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerBaseMapper")
public interface ICustomerBaseMapper {
    int deleteByPrimaryKey(Integer cbId);

    int insert(CustomerBase customerBase);

    int insertSelective(CustomerBase customerBase);

    CustomerBase selectByPrimaryKey(Integer cbId);

    int updateByPrimaryKeySelective(CustomerBase customerBase);

    int updateByPrimaryKey(CustomerBase customerBase);

    List<CustomerBase> selectByAll();
}