package com.isoft.erp.web.controller;

import com.alibaba.fastjson.JSON;
import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.Orderdetail;
import com.isoft.erp.service.inf.DepService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/4/3.
 */
@Controller
@RequestMapping("/dep")
public class DepController extends BaseController<Dep>{

    @Autowired
    private DepService depService;

    @RequestMapping("/listAllDep")
    @ResponseBody
    public List<Dep> listAllDep(){
        Map<String,Object> result=new HashedMap();
        List<Dep> deps = depService.listAllDep();

        result.put("dep",deps);
        System.out.println(JSON.toJSONString(deps));
        return deps;
    }

    @RequestMapping("/selectAllDep")
    @ResponseBody
    public Map<String,Object> selectAllDep(@RequestParam("page") String pageNumber,
                                           @RequestParam("rows") String pageSize){//easyui传入的是rows(每页显示的条数,对应pageSize),page(对应pageNumber)
        Map<String,Object> result=new HashMap();
        OraclePageBean<Orderdetail> oraclePageBean=new OraclePageBean(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),
                0,"uuid","desc");

        OraclePageBean<Dep> oraclePageBeanFulled = depService.selectAllDep(oraclePageBean);
        result.put("total",oraclePageBeanFulled.getTotal());//总共多少条数据
        result.put("rows",oraclePageBeanFulled.getRows());//所有的数据
        return result;
    }
}
