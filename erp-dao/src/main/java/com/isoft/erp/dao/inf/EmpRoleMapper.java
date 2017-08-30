package com.isoft.erp.dao.inf;

import com.isoft.erp.entity.po.EmpRoleExample;
import com.isoft.erp.entity.po.EmpRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpRoleMapper {
    int countByExample(EmpRoleExample example);

    int deleteByExample(EmpRoleExample example);

    int deleteByPrimaryKey(EmpRoleKey key);

    int insert(EmpRoleKey record);

    int insertSelective(EmpRoleKey record);

    List<EmpRoleKey> selectByExample(EmpRoleExample example);

    int updateByExampleSelective(@Param("record") EmpRoleKey record, @Param("example") EmpRoleExample example);

    int updateByExample(@Param("record") EmpRoleKey record, @Param("example") EmpRoleExample example);
}