package com.isoft.erp.service.impl;

import com.isoft.erp.dao.inf.DepMapper;
import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.DepExample;
import com.isoft.erp.service.inf.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dell on 2017/4/3.
 */
@Service
@Transactional
@SuppressWarnings("All")
public class DepServiceImpl extends BaseServiceImpl implements DepService{

    @Autowired
    private DepMapper depMapper;

    @Override
    public List<Dep> listAllDep() {
        List<Dep> deps = depMapper.listAllDep();
        return deps;
    }

    @Override
    public Integer selectCountFromDep(Dep dep) {
        Integer i = depMapper.selectCountFromDep(dep);
        return i;
    }

    @Override
    public OraclePageBean<Dep> selectAllDep(OraclePageBean oraclePageBean) {
        List<Dep> deps = depMapper.selectAllDep(oraclePageBean);

        oraclePageBean.setRows(deps);
        int i = this.countByExample(new DepExample());
        oraclePageBean.setTotal(i);
        return oraclePageBean;
    }

    @Override
    public int countByExample(DepExample example) {
        int i = depMapper.countByExample(example);
        return i;
    }
}
