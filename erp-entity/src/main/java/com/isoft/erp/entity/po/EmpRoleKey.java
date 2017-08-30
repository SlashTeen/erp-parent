package com.isoft.erp.entity.po;

import java.math.BigDecimal;

public class EmpRoleKey {
    private BigDecimal empuuid;

    private BigDecimal roleuuid;

    public BigDecimal getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(BigDecimal empuuid) {
        this.empuuid = empuuid;
    }

    public BigDecimal getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(BigDecimal roleuuid) {
        this.roleuuid = roleuuid;
    }
}