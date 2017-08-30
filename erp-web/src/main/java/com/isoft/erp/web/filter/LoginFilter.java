package com.isoft.erp.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dell on 2017/4/26.
 */
public class LoginFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String[] notFilter=new String[]{"user/login","/login.jsp"};
        String contextPath = request.getContextPath();///erp
        String requestURI = request.getRequestURI();///erp/login.jsp
        if(requestURI.indexOf(".jsp")!=-1){//如果请求路径含有.jsp形式
            boolean isFilter=true;
            for(String s:notFilter){
                if(requestURI.indexOf(s)!=-1){//如果包含不过滤的URL
                    isFilter=false;
                    break;
                }
            }
            if(isFilter){//开始过滤
                if(null==request.getSession().getAttribute("user")){
                    System.out.println(requestURI+">>>用户没有登陆");
                    response.sendRedirect(contextPath+"/login.jsp");
                    return;
                }else {
                    System.out.println(requestURI+">>>用户已经登陆");
                    filterChain.doFilter(request,response);
                    return;
                }
            }else {//不过滤直接放行
                System.out.println(requestURI+">>>不过滤放行");
                filterChain.doFilter(request,response);
                return;
            }
        }else {//如果请求路径不含有.jsp形式
            System.out.println(requestURI+">>>不过滤放行");
            filterChain.doFilter(request,response);
            return;
        }
    }

}
