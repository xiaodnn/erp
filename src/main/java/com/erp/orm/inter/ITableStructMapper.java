package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.TableStruct;

@Repository("tableStructMapper")
public interface ITableStructMapper {
    int deleteByPrimaryKey(Integer tsId);

    int insert(TableStruct tableStruct);

    int insertSelective(TableStruct tableStruct);

    TableStruct selectByPrimaryKey(Integer tsId);

    int updateByPrimaryKeySelective(TableStruct tableStruct);

    int updateByPrimaryKey(TableStruct tableStruct);

	List<TableStruct> selectByName(String name);

	List<TableStruct> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

	int createTable(Map<String,String> map);
	/**
	 * 根据主表ID获取子表结构信息
	 * @param tsMid
	 * @return
	 */
	TableStruct selectByTsMid(Integer tsMid);

}