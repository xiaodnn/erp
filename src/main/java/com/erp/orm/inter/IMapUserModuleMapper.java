package com.erp.orm.inter;
import java.util.List;
import java.util.Map;


import com.erp.orm.entity.MapUserModule;
import org.springframework.stereotype.Repository;

@Repository("mapUserModuleMapper")
public interface IMapUserModuleMapper {
    int deleteByPrimaryKey(Integer mumId);

    int insert(MapUserModule mapUserModule);

    int insertSelective(MapUserModule mapUserModule);

    MapUserModule selectByPrimaryKey(Integer mumId);

    int updateByPrimaryKeySelective(MapUserModule mapUserModule);

    int updateByPrimaryKey(MapUserModule mapUserModule);

	MapUserModule selectByCode(String oCode);

	List<MapUserModule> selectByPage(Map<String,Integer> map);

	Integer selectCount(Map<String,Object> map);

}