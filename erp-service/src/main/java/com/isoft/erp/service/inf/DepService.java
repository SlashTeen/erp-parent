package com.isoft.erp.service.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.DepExample;

import java.util.List;

/**
 * Created by dell on 2017/4/3.
 */
@SuppressWarnings("All")
public interface DepService extends BaseService {

    /**
     * 查询出所有的部门的信息,给emp的下拉选择框使用
     * @return
     */
    List<Dep> listAllDep();

    Integer selectCountFromDep(Dep dep);

    //分页使用
    OraclePageBean<Dep> selectAllDep(OraclePageBean oraclePageBean);
    int countByExample(DepExample example);
}
