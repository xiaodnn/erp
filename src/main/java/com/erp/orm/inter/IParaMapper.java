package com.erp.orm.inter;

import com.erp.orm.entity.Para;
import org.springframework.stereotype.Repository;

/**
 * 
 * 系统参数
 *
 * @author scy
 * @date 2016年12月6日
 */
@Repository("paraMapper")
public interface IParaMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Para para);

    int insertSelective(Para para);

    Para selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Para para);

    int updateByPrimaryKey(Para para);
}