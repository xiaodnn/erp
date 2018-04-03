package com.erp.orm.inter;

import com.erp.orm.entity.WarehousingDetail;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 入库明细
 *
 *
 * @author scy
 * @date 2017年1月2日
 */
@Repository("warehousingDetailMapper")
public interface IWarehousingDetailMapper {
	
    int deleteByPrimaryKey(Map<String,String> map);

    int insert(WarehousingDetail warehousingDetail);

    int insertSelective(WarehousingDetail warehousingDetail);

    WarehousingDetail selectByPrimaryKey(Integer wdId);

    int updateByPrimaryKeySelective(WarehousingDetail warehousingDetail);

    int updateByPrimaryKey(WarehousingDetail warehousingDetail);
    
}