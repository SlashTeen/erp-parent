package com.isoft.erp.entity.po;

import java.math.BigDecimal;

public class Storedetail {
    private BigDecimal uuid;

    private BigDecimal storeuuid;

    private BigDecimal goodsuuid;

    private BigDecimal num;

    public BigDecimal getUuid() {
        return uuid;
    }

    public void setUuid(BigDecimal uuid) {
        this.uuid = uuid;
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
}