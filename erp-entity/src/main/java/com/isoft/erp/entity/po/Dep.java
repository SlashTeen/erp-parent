package com.isoft.erp.entity.po;

public class Dep {
    private String uuid;

    private String deptname;

    private String tele;

    private String emp_count;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
    public String getEmp_count() {
        return emp_count;
    }

    public void setEmp_count(String emp_count) {
        this.emp_count = emp_count;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }
}