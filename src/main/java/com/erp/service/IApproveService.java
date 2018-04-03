/**
 * 
 */
package com.erp.service;

import java.util.List;

import com.erp.orm.entity.Approve;

/**
 * 审核流程设置
 * @author scy
 *
 */
public interface IApproveService {

	int delById(Integer aId);

    int save(Approve approve);

    int saveNotNull(Approve approve);

    Approve findById(Integer aId);
    
    Approve findByOgranAndModule(Integer organ, Integer module);

    int modifyByIdNotNull(Approve approve);

    int modifyById(Approve approve);

    /**
     * 根据机构ID、模块ID、用户ID 查询
     * @param uid
     * @param organ
     * @param module
     * @return
     */
    Approve findByOrder(Integer uid,Integer organ,Integer module);

    Approve findByMid(Integer mId);

	List<Approve> findAll();

    List<Approve> findByPage(Integer page, Integer rows) ;

    Integer findCount();
}
