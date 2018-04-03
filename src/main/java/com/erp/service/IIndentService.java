package com.erp.service;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Indent;

@Repository("indentService")
public interface IIndentService {
    int delById(Integer iId);

    int save(Indent indent);

    int saveNotNull(Indent indent);

    Indent findById(Integer iId);

    int modifyByIdNotNull(Indent indent);

    int modifyById(Indent indent);

	List<Indent> findByName(String name);

	List<Indent> findByPage(Integer page, Integer rows);

	Integer findCount( );

}
