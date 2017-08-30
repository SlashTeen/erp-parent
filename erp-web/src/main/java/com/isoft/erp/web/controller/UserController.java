package com.isoft.erp.web.controller;

import com.alibaba.fastjson.JSON;
import com.isoft.erp.entity.bean.OraclePageBean;
import com.isoft.erp.entity.po.Dep;
import com.isoft.erp.entity.po.Empl;
import com.isoft.erp.entity.po.QueryVO;
import com.isoft.erp.service.inf.UserService;
import com.isoft.erp.web.utils.ToEasyUIJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/3/23.
 */
@Controller
@RequestMapping("/user")
@SuppressWarnings("All")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(String username,String pwd,
                      HttpServletResponse response,HttpSession session) throws Exception{
        Map<String,String> result=new HashMap<String,String>();
        System.out.println("UserController#login");
        Empl empl = userService.login(username);
        if(empl==null){
            result.put("status","400");
            result.put("message","亲,你还没有注册,请先去注册");
            return result;
        }
        if(!username.equals(empl.getUsername())){
            result.put("status","400");
            result.put("message","用户名不正确");
            return result;
        }
        if(!pwd.equals(empl.getPwd())){
            result.put("status","400");
            result.put("message","密码不正确");
            return result;
        }
        session.setAttribute("user",empl);
        result.put("status","200");
//        String str = JSON.toJSONString(result);
//        System.out.print(str);
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(str);
        return result;
    }

    @RequestMapping("/logOut")
    public void logOut(HttpServletResponse response,HttpSession session) throws Exception{
        Map<String,String> result=new HashMap<String,String>();
        System.out.println("UserController#logOut");
        session.removeAttribute("user");
        result.put("status","200");
        String str = JSON.toJSONString(result);
        System.out.print(str);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(str);
    }

    @RequestMapping("/modifyPwd")
    @ResponseBody
    public Map<String,String> modifyPwd(HttpSession session, HttpServletRequest request){
        System.out.println("UserController#modifyPwd");
        String newPwd = request.getParameter("newPwd");
        String oldPwd = request.getParameter("oldPwd");
        Map<String,String> result=new HashMap<String,String>();

        Empl user =(Empl) session.getAttribute("user");//将session中的当前登陆对象取出修改密码,重新更新到数据库
        user.setPwd(newPwd);
        userService.modifyPwd(user);
        result.put("status","200");
        result.put("message","用户修改成功");
        return result;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map<String,Object> selectByPage(@RequestParam("page") String pageNumber,
                                 @RequestParam("rows") String pageSize){//easyui传入的是rows(每页显示的条数,对应pageSize),page(对应pageNumber)
        Map<String,Object> result=new HashMap();
        OraclePageBean<Empl> oraclePageBean=new OraclePageBean(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),0,"uuid","desc");
        OraclePageBean<Empl> oraclePageBeanFulled = userService.selectByPage(oraclePageBean);//中的rows是返还给easyui的每页记录数

        result.put("total",oraclePageBeanFulled.getTotal());//easyui需要封装成这种json格式
        result.put("rows",oraclePageBeanFulled.getRows());
        System.out.print(JSON.toJSONString(result,true));
        return result;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String,String> delUser(String uuid){
        Map<String,String> result=new HashMap<>();
        userService.delUser(uuid);

        result.put("status","200");
        result.put("message","删除成功!");
        return result;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String,Object> addUser(Empl empl,Dep dep){
        Map<String,Object> result=new HashMap();
        userService.addUser(dep,empl);
        result.put("status","200");
        return result;
    }

//    @RequestMapping("/selectRow")
//    public String selectRow(String uuid, HttpServletRequest request, Model model){
//        Empl empl =new Empl();
//        empl.setUuid(uuid);
//        Empl e=userService.selectRow(empl);//查询员工基本信息,
//        Dep dep = userService.selectDepByEmpuuid(empl);//和员工所属的部门
//        model.addAttribute("empl",e);
//        model.addAttribute("dep",dep);
//        return "/jsp/emp";
//    }

    @RequestMapping("/selectRow")
    @ResponseBody
    public String selectRow(String uuid, HttpServletRequest request,HttpServletResponse response)throws Exception{
        QueryVO queryVO=new QueryVO();
        Empl empl =new Empl();
        empl.setUuid(uuid);
        Empl e=userService.selectRow(empl);//查询员工基本信息,
        Dep dep = userService.selectDepByEmpuuid(empl);//和员工所属的部门
        queryVO.setEmpl(e);
        queryVO.setDep(dep);
        String stringJson = JSON.toJSONString(queryVO);
        String[] prefixs=new String[10];
        prefixs[0]="empl";
        prefixs[1]="dep";
        String str = ToEasyUIJson.toEasyUIJson(stringJson, prefixs);
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(str);
        return str;
    }

    @RequestMapping("/saveRow")
    @ResponseBody
    public Map<String,Object> saveRow(QueryVO queryVO){
        Map<String,Object> result=new HashMap();
        userService.saveRow(queryVO.getDep(),queryVO.getEmpl());

        result.put("status","200");
        return result;
    }
}
