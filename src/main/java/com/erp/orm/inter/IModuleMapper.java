package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.Module;
import org.springframework.stereotype.Repository;

@Repository("moduleMapper")
public interface IModuleMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Module module);

    int insertSelective(Module module);

    Module selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Module module);

    int updateByPrimaryKey(Module module);

    List<Module> selectByNikename(String nikename);

	List<Module> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}