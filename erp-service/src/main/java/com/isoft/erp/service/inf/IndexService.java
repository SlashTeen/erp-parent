package com.isoft.erp.service.inf;

import com.isoft.erp.entity.po.Menu;

import java.util.List;

/**
 * Created by dell on 2017/3/29.
 */
public interface IndexService {

    /**
     * 初始化左侧导航菜单
     * @return
     */
    Menu initMenu(String uuid);

}
