package com.erp.orm.inter;

import java.util.List;

import com.erp.orm.entity.Menu;
import org.springframework.stereotype.Repository;

@Repository("menuMapper")
public interface IMenuMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Menu menu);

    int insertSelective(Menu menu);

    Menu selectByPrimaryKey(Integer mId);

    List<Menu> selectAll();
    
    int updateByPrimaryKeySelective(Menu menu);

    int updateByPrimaryKey(Menu menu);
    
}