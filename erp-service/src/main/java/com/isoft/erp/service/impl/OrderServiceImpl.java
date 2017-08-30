package com.isoft.erp.service.impl;

import com.isoft.erp.dao.inf.OrderdetailMapper;
import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Orderdetail;
import com.isoft.erp.entity.po.OrderdetailExample;
import com.isoft.erp.service.inf.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dell on 2017/4/15.
 */
@Service
@Transactional
@SuppressWarnings("All")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public void insertOrders(List<Orderdetail> data) {
        orderdetailMapper.insertOrders(data);
    }

    @Override
    public OraclePageBean<Orderdetail> selectByPage(OraclePageBean<Orderdetail> oraclePageBean) {
        int i = countOrders();
        List<Orderdetail> orderdetails = orderdetailMapper.selectByPage(oraclePageBean);
        oraclePageBean.setTotal(i);
        oraclePageBean.setRows(orderdetails);
        return oraclePageBean;
    }

    @Override
    public int countOrders() {
        OrderdetailExample orderdetailExample=new OrderdetailExample();
        int i = orderdetailMapper.countByExample(orderdetailExample);
        return i;
    }

    @Override
    public List<Orderdetail> selectByConditions(OraclePageBean<Orderdetail> oraclePageBean) {
        List<Orderdetail> oraclePageBeanFulled = orderdetailMapper.selectByConditions(oraclePageBean);
        return oraclePageBeanFulled;
    }

    @Override
    public int countOrdersByConditions(Orderdetail orderdetail) {
        int i = orderdetailMapper.countOrdersByConditions(orderdetail);
        return i;
    }

}
