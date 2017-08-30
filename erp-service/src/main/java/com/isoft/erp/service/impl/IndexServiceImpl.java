package com.isoft.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.isoft.erp.dao.inf.MenuMapper;
import com.isoft.erp.entity.po.Menu;
import com.isoft.erp.service.inf.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/29.
 */
@Service
@Transactional
@SuppressWarnings("All")
public class IndexServiceImpl implements IndexService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu initMenu(String uuid) {
        List<Menu> menus = menuMapper.initMenu(uuid);//通过ROLE表中的roleuuid,就是角色,查出该角色所具有的菜单权限
        Menu menu0 = menus.get(0);//查询出根菜单
        Menu m0 = this.createMenu(menu0);
        menus.remove(0);
        for (Menu m:menus){//当正在遍历某个集合的时候对这个集合进行增删改查的操作会造成并发修改异常
            if(Integer.parseInt(m.getPid())==0){//如果是1级菜单,将1级菜单全部放到0级菜单下面
                Menu m1 = this.createMenu(m);
                m0.getMenus().add(m1);
                continue;
            }
            for (Menu m1:m0.getMenus()){
                if (Integer.parseInt(m.getPid())==Integer.parseInt(m1.getMenuid())){//如果2级菜单的父id等于1级菜单的id
                    m1.getMenus().add(m);//将2级菜单添加到对应的1级菜单的下面
                }
            }
        }
        System.out.print(JSON.toJSONString(m0,true));
        return m0;
    }

    /**
     * 克隆一个菜单
     * @param menu
     */
    private Menu createMenu(Menu menu){
        Menu m=new Menu();
        m.setMenuid(menu.getMenuid());
        m.setMenuname(menu.getMenuname());
        m.setIcon(menu.getIcon());
        m.setUrl(menu.getUrl());
        m.setMenus(new ArrayList());
        return m;
    }

}
