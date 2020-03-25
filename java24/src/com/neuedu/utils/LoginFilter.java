package com.neuedu.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/admin/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
        System.out.println("进入过滤器");
        //在此处做用户是否登录的验证  ---卡子  关口
        //判断session里是否存在loginUser
        HttpServletRequest httprequest=(HttpServletRequest)request;
        HttpSession session=httprequest.getSession();
        Object obj=session.getAttribute("loginUser");
        if(obj!=null){
        	//如果有就放行
        	// pass the request along the filter chain
    		chain.doFilter(request, response);
    		return ;
        }else{
        	//如果没有，就回登录页
        	HttpServletResponse httpresponse=(HttpServletResponse)response;
        	httpresponse.sendRedirect(httprequest.getContextPath()+"/login.jsp");
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
