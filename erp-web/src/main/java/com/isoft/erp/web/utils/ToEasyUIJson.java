package com.isoft.erp.web.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/4/8.
 */
public class ToEasyUIJson {

    public static String toEasyUIJson(String stringJson,String[] prefixs){
        Map<String,Object> newMap=new HashMap();
        Map<String,Object> objectJson = JSON.parseObject(stringJson);
        for(String key:objectJson.keySet()){
            Object o = objectJson.get(key);
            if(o instanceof Object && key.equals(prefixs[0])){//如果该数据是一个对象类型且前缀是数组的第一个值
                Map<String,Object> oMap=(Map<String,Object>)o;
                for (String sk1:oMap.keySet()){
                    newMap.put(prefixs[0]+"."+sk1,oMap.get(sk1));
                }
            }else if(o instanceof Object && key.equals(prefixs[1])){
                Map<String,Object> oMap=(Map<String,Object>)o;
                for (String sk2:oMap.keySet()){
                    newMap.put(prefixs[1]+"."+sk2,oMap.get(sk2));
                }
            }
        }
        String str = JSON.toJSONString(newMap);
        return str;
    }
}
