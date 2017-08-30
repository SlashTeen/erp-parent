package com.isoft.erp.web.controller;

import com.alibaba.fastjson.JSON;
import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Empl;
import com.isoft.erp.entity.po.Orderdetail;
import com.isoft.erp.service.inf.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/4/15.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insertOrders(String data){
        Map<String,Object> result=new HashMap<>();
        System.out.print("data:"+data);
        List<Orderdetail> orderdetails = JSON.parseArray(data, Orderdetail.class);
        System.out.print("orderdetails:"+orderdetails.toString());
        orderService.insertOrders(orderdetails);

        result.put("status","200");
        return result;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map<String,Object> selectByPage(@RequestParam("page") String pageNumber,
                                           @RequestParam("rows") String pageSize){//easyui传入的是rows(每页显示的条数,对应pageSize),page(对应pageNumber)
        Map<String,Object> result=new HashMap();
        OraclePageBean<Orderdetail> oraclePageBean=new OraclePageBean(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),
                0,"uuid","desc");

        OraclePageBean<Orderdetail> oraclePageBeanFulled = orderService.selectByPage(oraclePageBean);

        result.put("total",oraclePageBeanFulled.getTotal());//总共多少条数据
        result.put("rows",oraclePageBeanFulled.getRows());//所有的数据
        return result;
    }

    @RequestMapping("/search")
    @ResponseBody
    public Map<String,Object> selectByConditions(@RequestParam("page") String pageNumber,
                                                 @RequestParam("rows") String pageSize,
                                                 @RequestParam(value = "goodsname",required = false) String goodsname,
                                                 @RequestParam(value = "goodsuuid",required = false) String goodsuuid,
                                                 @RequestParam(value = "state",required = false) String state){//easyui传入的是rows(每页显示的条数,对应pageSize),page(对应pageNumber)
        Map<String,Object> result=new HashMap();
        Map<String,Object> params=new HashMap();
        params.put("goodsuuid",goodsuuid);
        params.put("goodsname",goodsname);
        params.put("state",state);

        OraclePageBean<Orderdetail> oraclePageBean=new OraclePageBean(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),
                0,"uuid","desc",params);
        List<Orderdetail> orderdetails = orderService.selectByConditions(oraclePageBean);

        Orderdetail orderdetail=new Orderdetail();
        if(StringUtils.isNotBlank(goodsuuid)
                &&StringUtils.isNotBlank(goodsname) &&StringUtils.isNotBlank(state)){
            orderdetail.setGoodsname(goodsname);
            orderdetail.setGoodsuuid(new BigDecimal(goodsuuid));
            orderdetail.setState(state);
        }
        int i = orderService.countOrdersByConditions(orderdetail);

        oraclePageBean.setTotal(i);
        oraclePageBean.setRows(orderdetails);

        result.put("total",oraclePageBean.getTotal());//总共多少条数据
        result.put("rows",oraclePageBean.getRows());//所有的数据
        return result;
    }
}
