package com.isoft.erp.service.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.Empl;

import java.util.List;

/**
 * Created by dell on 2017/3/28.
 */
@SuppressWarnings("All")
public interface UserService {

    public Empl login(String username);

    void modifyPwd(Empl emp);

    List<Empl> getAllUser();

    OraclePageBean selectByPage(OraclePageBean oraclePageBean);

    void delUser(String uuid);

    Integer countAllUser();

    Integer selectMaxUUID();

    void addUser(Dep dep, Empl emp);

    Empl selectRow(Empl emp);

    Dep selectDepByEmpuuid(Empl empl);

    void saveRow(Dep dep, Empl emp);
}
