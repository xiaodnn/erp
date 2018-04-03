/**
 * 
 */
package com.erp.dao;

import java.util.List;

import com.erp.orm.entity.Approve;

/**
 * @author scy
 *
 */
public interface IApproveDao {

	int deleteByPrimaryKey(Integer aId);

    int insert(Approve approve);

    int insertSelective(Approve approve);

    Approve selectByPrimaryKey(Integer aId);
    
    Approve selectByOgranAndModule(Integer organ, Integer module);

    int updateByPrimaryKeySelective(Approve approve);

    int updateByPrimaryKey(Approve approve);

    /**
     * 根据机构ID、模块ID、用户ID 查询
     * @param uid
     * @param organ
     * @param module
     * @return
     */
    Approve selectByOrder(Integer uid,Integer organ,Integer module );

    /**
     * 根据模块ID,查询需审批部门和人员信息
     * @param mId
     * @return
     */
    Approve selectByMid(Integer mId);

	List<Approve> selectAll();

    List<Approve> selectByPage(Integer page, Integer rows);

    Integer selectCount();
}
