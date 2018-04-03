package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.Indent;

@Repository("indentMapper")
public interface IIndentMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Indent indent);

    int insertSelective(Indent indent);

    Indent selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Indent indent);

    int updateByPrimaryKey(Indent indent);

	List<Indent> selectByName(String name);

	List<Indent> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}