package com.isoft.erp.entity.po;

import java.math.BigDecimal;
import java.util.Date;

public class Storeoper {
    private BigDecimal uuid;

    private BigDecimal empuuid;

    private Date opertime;

    private BigDecimal storeuuid;

    private BigDecimal goodsuuid;

    private BigDecimal num;

    private String type;

    public BigDecimal getUuid() {
        return uuid;
    }

    public void setUuid(BigDecimal uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(BigDecimal empuuid) {
        this.empuuid = empuuid;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    public BigDecimal getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(BigDecimal storeuuid) {
        this.storeuuid = storeuuid;
    }

    public BigDecimal getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(BigDecimal goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}