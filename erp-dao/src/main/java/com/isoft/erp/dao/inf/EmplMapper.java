package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.Empl;
import com.isoft.erp.entity.po.EmplExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmplMapper {

    Empl selectByUserName(String username);

    int countByExample(EmplExample example);

    int deleteByExample(EmplExample example);

    int deleteByPrimaryKey(BigDecimal uuid);

    int insert(Empl record);

    int insertSelective(Empl record);

    /**
     * @param example
     * @return
     */
    List<Empl> selectByExample(EmplExample example);

    /**
     * 分页查询
     * @param oraclePageBean
     */
    List<Empl> selectByPage(OraclePageBean oraclePageBean);

    /**
     * 查出当前最大的uuid
     * @return
     */
    Integer selectMaxUUID();

    Empl selectByPrimaryKey(BigDecimal uuid);

    Dep selectDepByEmpuuid(Empl empl);

    int updateByExampleSelective(@Param("record") Empl record, @Param("example") EmplExample example);

    int updateByExample(@Param("record") Empl record, @Param("example") EmplExample example);

    int updateByPrimaryKeySelective(Empl record);

    int updateByPrimaryKey(Empl record);

}