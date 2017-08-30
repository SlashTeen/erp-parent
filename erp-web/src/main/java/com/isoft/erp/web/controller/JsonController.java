package com.isoft.erp.web.controller;

import com.isoft.erp.entity.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/4/25.
 */
@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/map1Params")
    @ResponseBody
    public Map<String,Object> map1Params(Person person){//参数只是个bean
        //name=tom1&age=22-post-form-application/x-www-form-urlencoded-success
        //?name=lucy2&age=21-get-form-success

        //json对象-post-ajax-数据类型是json-没设置contentType-success
        //json对象-post-ajax-数据类型是json-contentType是application/json-请求成功,数据绑定失败
        //json字符串-post-ajax-数据类型是json-没设置contentType-请求成功,但是数据绑定失败
        //json字符串-post-ajax-数据类型是json-contentType是application/json-请求成功,但是数据绑定失败

        //json对象-get-ajax-数据类型是json-没设置contentType-success
        //json对象-get-ajax-数据类型是json-contentType是application/json-success
        //json字符串-get-ajax-数据类型是json-没设置contentType-请求成功,数据绑定失败
        //json字符串-get-ajax-数据类型是json-contentType是application/json-请求成功,数据绑定失败

        //post-ajax-在URL后拼字符串-数据类型是json-没设置contentType-success
        //post-ajax-在URL后拼字符串-数据类型是json-contentType:application/json-success
        //get-ajax-在URL后拼字符串-数据类型是json-没设置contentType-success
        //get-ajax-在URL后拼字符串-数据类型是json-contentType:application/json-success
        //没有method,没有contentType-success,只是URL拼字符串形式-success
        System.out.println(person.getAge()+""+person.getName());
        Map<String,Object> result=new HashMap();

        return result;
    }

    @RequestMapping("/map2Params")
    @ResponseBody
    public Map<String,Object> map2Params(@RequestBody Person person){//bean加注解
        //?name=lucy2&age=21-get-form-text/html;charset=utf-8-400
        //name=tom1&age=22-post-form-text/html-415

        //json对象-post-ajax-数据类型是json-没设置contentType-415
        //json对象-post-ajax-数据类型是json-contentType是application/json-400
        //json字符串-post-ajax-数据类型是json-没设置contentType-415
        //json字符串-post-ajax-数据类型是json-contentType是application/json-success

        //json对象-get-ajax-数据类型是json-没设置contentType-400
        //json对象-get-ajax-数据类型是json-contentType是application/json-400
        //json字符串-get-ajax-数据类型是json-没设置contentType-400
        //json字符串-get-ajax-数据类型是json-contentType是application/json-400
//结论:get请求应该是在URL后面拼字符串的形式,使用json对象格式发get请求是不合理的

        //post-ajax-在URL后拼字符串-数据类型是json-没设置contentType-400
        //post-ajax-在URL后拼字符串-数据类型是json-contentType:application/json-400
        //get-ajax-在URL后拼字符串-数据类型是json-没设置contentType-400
        //get-ajax-在URL后拼字符串-数据类型是json-contentType:application/json-400
        //没有method,没有contentType-success,只是URL拼字符串形式-400

//总结论:ajax如果发送的data是json字符串映射的实体类必须使用@RequestBody注解解析,且必须设置ContentType的媒体类型
        System.out.println(person.getAge()+""+person.getName());
        Map<String,Object> result=new HashMap();

        return result;
    }

    @RequestMapping("/map3Params")
    @ResponseBody
    public Map<String,Object> map3Params(String name,int age){
        System.out.print("name:"+name+"age:"+age);
        Map<String,Object> result=new HashMap();
        //get-form-success
        //post-form-success
        //json对象-post-ajax-数据类型是json-没设置contentType-success
        //json对象-post-ajax-数据类型是json-contentType是application/json-500,Optional int parameter 'age' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
        //json字符串-post-ajax-数据类型是json-没设置contentType-500
        //json字符串-post-ajax-数据类型是json-contentType是application/json-500

        //json对象-get-ajax-数据类型是json-没设置contentType-success
        //json对象-get-ajax-数据类型是json-contentType是application/json-success
        //json字符串-get-ajax-数据类型是json-没设置contentType-500
        //json字符串-get-ajax-数据类型是json-contentType是application/json-500
        return result;
    }

    @RequestMapping("/map4Params")
    @ResponseBody
    public Map<String,Object> map4Params(@RequestParam String name,
                                         @RequestParam Integer age){
        System.out.print("name:"+name+"age:"+age);
        Map<String,Object> result=new HashMap();
        //get-form-success
        //post-form-success

        //json对象-post-ajax-数据类型是json-没设置contentType-success
        //json对象-post-ajax-数据类型是json-contentType是application/json-400
        //json字符串-post-ajax-数据类型是json-没设置contentType-400
        //json字符串-post-ajax-数据类型是json-contentType是application/json-400

        //json对象-get-ajax-数据类型是json-没设置contentType-success
        //json对象-get-ajax-数据类型是json-contentType是application/json-success
        //json字符串-get-ajax-数据类型是json-没设置contentType-400
        //json字符串-get-ajax-数据类型是json-contentType是application/json-400
        return result;
    }
}
