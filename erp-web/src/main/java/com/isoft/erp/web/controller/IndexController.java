package com.isoft.erp.web.controller;

import com.alibaba.fastjson.JSON;
import com.isoft.erp.entity.po.Menu;
import com.isoft.erp.service.inf.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/3/29.
 */
@Controller
@RequestMapping("/index")
@SuppressWarnings("All")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/init")
    @ResponseBody
    public Menu inintMenu(){
        Menu menus = indexService.initMenu("1");
        System.out.print(menus);
        return menus;
    }

    @RequestMapping("/init2")
    @ResponseBody
    public Menu inint(){
        Map<String,Object> result= new HashMap();
        Menu menus = indexService.initMenu("1");
        System.out.print(menus);
        result.put("menus",menus);
        return menus;
    }

    public void inint(HttpServletResponse response)throws Exception{
        Menu menus = indexService.initMenu("1");
        System.out.print(menus);
        String str = JSON.toJSONString(menus);
        System.out.print(str);
        response.setContentType("text/html;UTF-8");
        response.getWriter().write(str);
    }
}
