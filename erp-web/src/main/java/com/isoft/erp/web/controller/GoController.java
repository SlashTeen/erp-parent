package com.isoft.erp.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by dell on 2017/3/23.
 */
@Controller
public class GoController implements EnvironmentAware{

    private final Log logger= LogFactory.getLog(GoController.class);
    private Environment environment=null;

    @RequestMapping(value={"/"},method={RequestMethod.HEAD})
    public String head(){
        return "/common/go";
    }

    @RequestMapping(value={"/index","/"},method={RequestMethod.GET})
    public String index(Model model){
        logger.info("============index==================");
        model.addAttribute("msg","msg");
        System.out.println(environment);
        return "go";
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }
}
