package com.isoft.erp.service.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Orderdetail;

import java.util.List;

/**
 * Created by dell on 2017/4/15.
 */
public interface OrderService {

    void insertOrders(List<Orderdetail> data);

    OraclePageBean<Orderdetail> selectByPage(OraclePageBean<Orderdetail> oraclePageBean);

    int countOrders();

    List<Orderdetail> selectByConditions(OraclePageBean<Orderdetail> oraclePageBean);

    int countOrdersByConditions(Orderdetail orderdetail);
}
