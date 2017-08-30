package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Orderdetail;
import com.isoft.erp.entity.po.OrderdetailExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderdetailMapper {

    /**
     * 录入多条销售记录
     */
    void insertOrders(List<Orderdetail> data);

    /**
     * 分页
     * @param example
     */
    int countByExample(OrderdetailExample example);
    List<Orderdetail> selectByPage(OraclePageBean<Orderdetail> oraclePageBean);

    //多条件检索
    List<Orderdetail> selectByConditions(OraclePageBean<Orderdetail> oraclePageBean);
    int countOrdersByConditions(Orderdetail orderdetail);

    int deleteByExample(OrderdetailExample example);

    int deleteByPrimaryKey(BigDecimal uuid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    Orderdetail selectByPrimaryKey(BigDecimal uuid);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}