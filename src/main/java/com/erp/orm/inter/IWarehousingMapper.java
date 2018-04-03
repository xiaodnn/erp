package com.erp.orm.inter;

import java.util.List;
import java.util.Map;

import com.erp.orm.entity.Warehousing;
import org.springframework.stereotype.Repository;

/**
 * 入库信息
 *
 *
 * @author scy
 * @date 2017年1月2日
 */
@Repository("warehousingMapper")
public interface IWarehousingMapper {
    int deleteByPrimaryKey(String whId);

    int insert(Warehousing warehousing);

    int insertSelective(Warehousing warehousing);

    Warehousing selectByPrimaryKey(String whId);

    int updateByPrimaryKeySelective(Warehousing warehousing);

    int updateByPrimaryKey(Warehousing warehousing);

	List<Warehousing> selectByIdOrTimeOrCreator(Map<String, String> map);
	
	List<Warehousing> selectAll();

    List<Warehousing> selectByPage(Map<String, Integer> map);

    Integer selectCount(Map<String, Object> map);
}