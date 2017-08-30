package com.isoft.erp.entity.bean;

import java.util.List;

/**
 * Created by dell on 2017/4/2.
 * 这个类没有用
 */
@SuppressWarnings("All")
public class EasyUIPageBean {
    private Boolean status=true;
    private int code=200;
    private String message;
    private int total;//总共有多少条记录
    private List<Object> rows;//所有的记录内容

    public EasyUIPageBean(){

    }

    public EasyUIPageBean(Boolean status, int code){
        this.status=status;
        this.code=code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }
}
