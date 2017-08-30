package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.DepExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DepMapper extends BaseMapper{

    /**
     * 查询出所有的部门的名称,给emp的下拉的列表框使用
     * @return
     */
    List<Dep> listAllDep();

    Integer selectCountFromDep(Dep dep);

    //分页使用
    List<Dep> selectAllDep(OraclePageBean oraclePageBean);
    int countByExample(DepExample example);

    void updateByDepName(Dep dep);

    int deleteByExample(DepExample example);

    int deleteByPrimaryKey(BigDecimal uuid);

    int insert(Dep record);

    int insertSelective(Dep record);

    List<Dep> selectByExample(DepExample example);

    Dep selectByPrimaryKey(BigDecimal uuid);

    int updateByExampleSelective(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByExample(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);
}