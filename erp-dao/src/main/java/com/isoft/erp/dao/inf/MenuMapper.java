package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.po.Menu;
import com.isoft.erp.entity.po.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(String menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    /**
     * @param example,加载首页的主菜单使用
     * @return
     */
    List<Menu> initMenu(String uuid);

    List<Menu> selectByExample(MenuExample example);

    /**
     * @param menuid,查询根菜单时使用
     * @return
     */
    Menu selectByPrimaryKey(String menuid);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}