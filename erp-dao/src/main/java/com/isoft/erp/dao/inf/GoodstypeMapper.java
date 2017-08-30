package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Goodstype;
import com.isoft.erp.entity.po.GoodstypeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstypeMapper {

    //对商品类型分页
    List<Goodstype> listByPage(OraclePageBean<Goodstype> oraclePageBean);
    //分页
    int countByExample(GoodstypeExample example);

    int deleteByExample(GoodstypeExample example);

    int deleteByPrimaryKey(BigDecimal uuid);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);

    List<Goodstype> selectByExample(GoodstypeExample example);

    Goodstype selectByPrimaryKey(BigDecimal uuid);

    int updateByExampleSelective(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);
}