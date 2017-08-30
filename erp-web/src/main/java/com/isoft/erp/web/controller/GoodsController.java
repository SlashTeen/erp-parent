package com.isoft.erp.web.controller;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Goods;
import com.isoft.erp.entity.po.Goodstype;
import com.isoft.erp.service.inf.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/4/18.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/listGoods")
    @ResponseBody
    public Map<String,Object> listGoods(@RequestParam("page") String pageNumber,
                                        @RequestParam("rows") String pageSize){
        Map<String,Object> result=new HashMap();
        OraclePageBean<Goodstype> oraclePageBean=new OraclePageBean<>(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),
                0,"uuid","desc");
        OraclePageBean<Goodstype> oraclePageBeanFulled=goodsService.listByPage(oraclePageBean);

        result.put("total",oraclePageBeanFulled.getTotal());//总共多少条数据
        result.put("rows",oraclePageBeanFulled.getRows());//所有的数据
        return result;
    }

    @RequestMapping("/goodsdetail")
    @ResponseBody
    public Map<String,Object> getGoodsRow(@RequestParam("uuid") String goodstypeuuid,
                                          @RequestParam("page") String pageNumber,
                                          @RequestParam("rows") String pageSize){
        Map<String,Object> result=new HashMap();
        Map<String,Object> params=new HashMap();
        params.put("goodstypeuuid",goodstypeuuid);
        OraclePageBean<Goods> oraclePageBean=new OraclePageBean<>(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),
                0,"uuid","desc",params);
        OraclePageBean<Goods> oraclePageBeanFulled = goodsService.getGoodsRow(oraclePageBean);

        result.put("total",oraclePageBeanFulled.getTotal());//总共多少条数据
        result.put("rows",oraclePageBeanFulled.getRows());//所有的数据
        return result;
    }
}
