package com.erp.service;


import java.util.List;

import com.erp.orm.entity.ApproveHistory;

public interface IApproveHistoryService {
    int delById(Integer ahId);

    int save(ApproveHistory approveHistory);

    int saveNotNull(ApproveHistory approveHistory);

    ApproveHistory findById(Integer ahId);

    int modifyByIdNotNull(ApproveHistory approveHistory);

    int modifyById(ApproveHistory approveHistory);

	ApproveHistory findByCode(String oCode);

	List<ApproveHistory> findByPage(Integer page, Integer rows);

	Integer findCount( );

    List<ApproveHistory> findByRid(String rId);
}
