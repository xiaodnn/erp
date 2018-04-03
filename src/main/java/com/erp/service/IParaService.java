/**
 * 
 */
package com.erp.service;

import com.erp.orm.entity.Para;

/**
 *
 * 系统参数
 * @author scy
 * @date 2016年12月6日
 */
public interface IParaService {
	int delById(Integer pId);

    int save(Para para);

    int saveNotNull(Para para);

    Para findById(Integer pId);

    int modifyByIdNotNull(Para para);

    int modifyById(Para para);
}
