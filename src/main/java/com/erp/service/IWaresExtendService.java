/**
 * 
 */
package com.erp.service;

import com.erp.orm.entity.WaresExtend;

/**
 * 商品扩展信息
 *
 * @author scy
 * @date 2016年12月14日
 */
public interface IWaresExtendService {

	int delById(String wId);

    int save(WaresExtend waresExtend);

    int saveNotNull(WaresExtend waresExtend);

    WaresExtend findById(String wId);

    int modifyByIdNotNull(WaresExtend waresExtend);

    int modifyById(WaresExtend waresExtend);
    
}
