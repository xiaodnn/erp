package com.erp.orm.inter;

import com.erp.orm.entity.MenuSub;

public interface IMenuSubMapper {
    int deleteByPrimaryKey(Integer msId);

    int insert(MenuSub record);

    int insertSelective(MenuSub record);

    MenuSub selectByPrimaryKey(Integer msId);

    int updateByPrimaryKeySelective(MenuSub record);

    int updateByPrimaryKey(MenuSub record);
}