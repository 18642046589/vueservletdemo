package com.neuedu.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyFilter
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("上下文销毁");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     * ServletContext---application
     */
    public void contextInitialized(ServletContextEvent applicationEvent)  { 
    	ServletContext application=applicationEvent.getServletContext();
    	//在线人数，初始化为0
    	application.setAttribute("onlinenumber", 0);
         System.out.println("上下文创建");
    }
	
}
