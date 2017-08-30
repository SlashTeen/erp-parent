package com.isoft.erp.entity.po;

import java.math.BigDecimal;

public class Store {
    private BigDecimal uuid;

    private String name;

    private BigDecimal empuuid;

    public BigDecimal getUuid() {
        return uuid;
    }

    public void setUuid(BigDecimal uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(BigDecimal empuuid) {
        this.empuuid = empuuid;
    }
}