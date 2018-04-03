/**
 * 
 */
package com.erp.service;

import java.util.List;

import com.erp.orm.entity.Warehousing;

/**
 * 入库信息
 *
 * @author scy
 * @date 2017年1月2日
 */
public interface IWarehousingService {

	int delById(String whId);

    int save(Warehousing warehousing);

    int saveNotNull(Warehousing warehousing);

    Warehousing findById(String whId);

    int modifyByIdNotNull(Warehousing warehousing);

    int modifyById(Warehousing warehousing);

	List<Warehousing> findWarehousing(String whId, String whInitime, String whCreator);
    
	List<Warehousing> findAll();

    List<Warehousing> findByPage(Integer page, Integer rows);

    Integer findCount();
}
