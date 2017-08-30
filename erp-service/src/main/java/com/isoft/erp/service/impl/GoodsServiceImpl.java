package com.isoft.erp.service.impl;

import com.isoft.erp.dao.inf.GoodsMapper;
import com.isoft.erp.dao.inf.GoodstypeMapper;
import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Goods;
import com.isoft.erp.entity.po.GoodsExample;
import com.isoft.erp.entity.po.Goodstype;
import com.isoft.erp.entity.po.GoodstypeExample;
import com.isoft.erp.service.inf.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dell on 2017/4/18.
 */
@Service
@Transactional
@SuppressWarnings("All")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodstypeMapper goodstypeMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public OraclePageBean<Goodstype> listByPage(OraclePageBean<Goodstype> oraclePageBean) {
        GoodstypeExample goodstypeExample=new GoodstypeExample();
        int i = goodstypeMapper.countByExample(goodstypeExample);
        List<Goodstype> goodstypes=goodstypeMapper.listByPage(oraclePageBean);

        oraclePageBean.setRows(goodstypes);
        oraclePageBean.setTotal(i);
        return oraclePageBean;
    }

    @Override
    public OraclePageBean<Goods> getGoodsRow(OraclePageBean<Goods> oraclePageBean) {
        int i = goodsMapper.countByExample(new GoodsExample());
        List<Goods> goodsRow = goodsMapper.getGoodsRow(oraclePageBean);

        oraclePageBean.setRows(goodsRow);
        oraclePageBean.setTotal(i);
        return oraclePageBean;
    }
}
