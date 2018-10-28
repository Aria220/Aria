package com.yixutech.library.mapper;

import java.util.List;

import com.yixutech.library.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> selectAll();

    List<Menu> selectByParentId(Long parentId);

    List<Menu> treeMenus();
}