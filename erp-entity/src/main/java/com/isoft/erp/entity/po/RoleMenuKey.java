package com.isoft.erp.entity.po;

import java.math.BigDecimal;

public class RoleMenuKey {
    private BigDecimal roleuuid;

    private String menuuuid;

    public BigDecimal getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(BigDecimal roleuuid) {
        this.roleuuid = roleuuid;
    }

    public String getMenuuuid() {
        return menuuuid;
    }

    public void setMenuuuid(String menuuuid) {
        this.menuuuid = menuuuid == null ? null : menuuuid.trim();
    }
}