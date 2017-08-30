package com.isoft.erp.service.inf;

import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Goods;
import com.isoft.erp.entity.po.Goodstype;

/**
 * Created by dell on 2017/4/18.
 */
public interface GoodsService {

    OraclePageBean<Goodstype> listByPage(OraclePageBean<Goodstype> oraclePageBean);

    OraclePageBean<Goods> getGoodsRow(OraclePageBean<Goods> oraclePageBean);
}
