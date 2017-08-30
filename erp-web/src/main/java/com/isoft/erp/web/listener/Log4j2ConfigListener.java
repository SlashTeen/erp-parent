package com.isoft.erp.web.listener;


import org.apache.logging.log4j.core.config.Configurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

@WebListener()
public class Log4j2ConfigListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static final String KEY = "log4j.configurationFile";//自定义的

    // Public constructor is required by servlet spec
    public Log4j2ConfigListener() {
    }

    /**
     * ServletContextListener implementation
     * This method is called when the servlet context is initialized(when the Web application is deployed).
     * You can initialize servlet context related data here.
     */
    public void contextInitialized(ServletContextEvent sce) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatted = simpleDateFormat.format(date);
        String path = getLog4jPath(sce);
        System.out.println(dateFormatted+":log4j2.xml日志文件路径是:"+path);
        Configurator.initialize("log4j2", "classpath:" + path);
    }

    /**
     * @param sce,获取log4j配置文件的路径
     */
    private String getLog4jPath(ServletContextEvent sce){
        Enumeration<String> initParameterNames = sce.getServletContext().getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String aName = initParameterNames.nextElement();
            String aValue = sce.getServletContext().getInitParameter(aName);
            if(aName.trim().equals(KEY)){
                return aValue;
            }
        }
        return null;
    }

    /**
     * This method is invoked when the Servlet Context(the Web application) is
     * undeployed or Application Server shuts down.
     */
    public void contextDestroyed(ServletContextEvent sce) {

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // Session is created.
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {

    }

    //Session is destroyed.
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------
    //This method is called when an attribute is added to a session.
    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    //This method is called when an attribute is removed from a session.
    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    //This method is invoked when an attibute is replaced in a session.
    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}
