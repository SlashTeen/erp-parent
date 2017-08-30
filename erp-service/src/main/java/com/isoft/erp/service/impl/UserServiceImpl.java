package com.isoft.erp.service.impl;

import com.isoft.erp.dao.inf.DepMapper;
import com.isoft.erp.dao.inf.EmplMapper;
import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.DepExample;
import com.isoft.erp.entity.po.Empl;
import com.isoft.erp.entity.po.EmplExample;
import com.isoft.erp.service.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by dell on 2017/3/28.
 * spring默认会对运行时异常进行事物回滚,
 * REQUIRED,如果有事物就加入到当前事物,没有事物新建一个事物,
 * NOT_SUPPORTED,声明方法是没有事物的,如果方法已经在一个事物之中运行则挂起该方法
 * SUPPOTS,如果该方法在一个事物之中被调用则就在事物之中运行,如果该方法在没有事物之中也可以运行
 */
@Service
@SuppressWarnings("All")
@Transactional(rollbackOn = Exception.class)//对未检测到的异常进行回滚
//@Transactional(rollbackOn = RuntimeException.class)//对检测到的异常进行回滚
public class UserServiceImpl implements UserService {

    @Autowired
    private EmplMapper emplMapper;
    @Autowired
    private DepMapper depMapper;

    @Override
    public Empl login(String username) {
        Empl empl = emplMapper.selectByUserName(username);
        return empl;
    }

    @Override
    public void modifyPwd(Empl empl) {
        EmplExample emplExample=new EmplExample();
        EmplExample.Criteria criteria = emplExample.createCriteria();
        criteria.andUuidEqualTo(new BigDecimal(empl.getUuid()));
        emplMapper.updateByExample(empl,emplExample);
    }

    @Override
    public List<Empl> getAllUser() {//非分页全查询
        EmplExample emplExample=new EmplExample();
        emplExample.setOrderByClause("uuid");
        List<Empl> empls = emplMapper.selectByExample(emplExample);
        return empls;
    }

    @Override
    public OraclePageBean selectByPage(OraclePageBean oraclePageBean) {//分页查询
        Integer total = countAllUser();
        List<Empl> empls = emplMapper.selectByPage(oraclePageBean);
        oraclePageBean.setRows(empls);
        oraclePageBean.setTotal(total);
        return oraclePageBean;
    }

    @Override
    public void delUser(String uuid) {
        int i = emplMapper.deleteByPrimaryKey(new BigDecimal(uuid));
        System.out.print("删除"+i+"条员工数据!");
    }

    @Override
    public Integer countAllUser() {
        EmplExample emplExample=new EmplExample();
        int total = emplMapper.countByExample(emplExample);
        return total;
    }


    @Override
    public Integer selectMaxUUID() {//查出当前员工的最大编号
        Integer maxUUID = emplMapper.selectMaxUUID();
        return maxUUID;
    }

    @Override
    public void addUser(Dep dep, Empl emp) {
        emp.setUuid(String.valueOf(selectMaxUUID()+1));//新员工的uuid是当前最新uuid+1
        emp.setDepuuid(dep.getDeptname());//deptname字段传到后台的值是depuuid
        Integer i = depMapper.selectCountFromDep(dep);//通过Dep#name查询该部门人数
        Integer x=new Integer(i+1);
        dep.setEmp_count(String.valueOf(x));//将该部门人数加1

        emplMapper.insertSelective(emp);
        depMapper.updateByDepName(dep);
    }

    @Override
    public Empl selectRow(Empl emp) {
        Empl empl = emplMapper.selectByPrimaryKey(new BigDecimal(emp.getUuid()));
        return empl;
    }
    @Override
    public Dep selectDepByEmpuuid(Empl empl) {
        Dep dep = emplMapper.selectDepByEmpuuid(empl);
        return dep;
    }

    @Override
    public void saveRow(Dep dep, Empl emp) {
        emplMapper.updateByPrimaryKey(emp);
    }
}
