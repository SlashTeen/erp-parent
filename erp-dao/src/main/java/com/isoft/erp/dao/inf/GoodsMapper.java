package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Goods;
import com.isoft.erp.entity.po.GoodsExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsMapper {

    //分页
    int countByExample(GoodsExample example);
    List<Goods> getGoodsRow(OraclePageBean<Goods> oraclePageBean);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(BigDecimal uuid);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(BigDecimal uuid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

}