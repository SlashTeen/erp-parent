package com.isoft.erp.entity.po;

import java.math.BigDecimal;

public class Role {
    private BigDecimal uuid;

    private String name;

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
}