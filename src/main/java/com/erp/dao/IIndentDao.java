package com.erp.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Indent;

@Repository("indentDao")
public interface IIndentDao {
    int deleteByPrimaryKey(Integer iId);

    int insert(Indent indent);

    int insertSelective(Indent indent);

    Indent selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Indent indent);

    int updateByPrimaryKey(Indent indent);

	List<Indent> selectByName(String name);

	List<Indent> selectByPage(Integer page, Integer rows);

	Integer selectCount( );

}
