package com.isoft.erp.entity.po;

import java.math.BigDecimal;
import java.util.Date;

public class Orderdetail {
    private BigDecimal uuid;

    private BigDecimal goodsuuid;

    private String goodsname;

    private BigDecimal price;

    private BigDecimal num;

    private BigDecimal money;

    private Date endtime;

    private BigDecimal ender;

    private BigDecimal storeuuid;

    private String state;

    private BigDecimal ordersuuid;

    public BigDecimal getUuid() {
        return uuid;
    }

    public void setUuid(BigDecimal uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(BigDecimal goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getEnder() {
        return ender;
    }

    public void setEnder(BigDecimal ender) {
        this.ender = ender;
    }

    public BigDecimal getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(BigDecimal storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getOrdersuuid() {
        return ordersuuid;
    }

    public void setOrdersuuid(BigDecimal ordersuuid) {
        this.ordersuuid = ordersuuid;
    }
}