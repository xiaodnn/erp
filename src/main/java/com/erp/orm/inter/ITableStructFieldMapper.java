package com.erp.orm.inter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


import com.erp.orm.entity.TableStructField;

@Repository("tableStructFieldMapper")
public interface ITableStructFieldMapper {
    int deleteByPrimaryKey(Integer tsfId);

    int insert(TableStructField tableStructField);

    int insertSelective(TableStructField tableStructField);

    TableStructField selectByPrimaryKey(Integer tsfId);

    int updateByPrimaryKeySelective(TableStructField tableStructField);

    int updateByPrimaryKey(TableStructField tableStructField);

	List<TableStructField> selectByName(String name);

	List<TableStructField> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}