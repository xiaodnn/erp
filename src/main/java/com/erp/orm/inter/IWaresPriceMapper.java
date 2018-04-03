package com.erp.orm.inter;

import com.erp.orm.entity.WaresPrice;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 
 * 商品价格信息
 *
 * @author scy
 * @date 2016年12月14日
 */
@Repository("waresPriceMapper")
public interface IWaresPriceMapper {
	
    int deleteByPrimaryKey(String wId);

    int insert(WaresPrice waresPrice);

    int insertSelective(WaresPrice waresPrice);

    WaresPrice selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(WaresPrice waresPrice);

    int updateByPrimaryKey(WaresPrice waresPrice);

    int updateByWid(Map<String,Object> map);

    int insertOrUpdate(WaresPrice waresPrice);
}