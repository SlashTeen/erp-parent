package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.po.Storeoper;
import com.isoft.erp.entity.po.StoreoperExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreoperMapper {
    int countByExample(StoreoperExample example);

    int deleteByExample(StoreoperExample example);

    int deleteByPrimaryKey(BigDecimal uuid);

    int insert(Storeoper record);

    int insertSelective(Storeoper record);

    List<Storeoper> selectByExample(StoreoperExample example);

    Storeoper selectByPrimaryKey(BigDecimal uuid);

    int updateByExampleSelective(@Param("record") Storeoper record, @Param("example") StoreoperExample example);

    int updateByExample(@Param("record") Storeoper record, @Param("example") StoreoperExample example);

    int updateByPrimaryKeySelective(Storeoper record);

    int updateByPrimaryKey(Storeoper record);
}