package com.neuedu.utils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.neuedu.pojo.User;

/**
 * Application Lifecycle Listener implementation class MySessionLoginListener
 *
 */
@WebListener
public class MySessionLoginListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MySessionLoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent sessionEvent)  { 
    	// TODO Auto-generated method stub
    			User user=(User)sessionEvent.getSession().getAttribute("loginUser");
    			HttpSession session=sessionEvent.getSession();
    	        ServletContext application= session.getServletContext();
    	        int old_online=(Integer)application.getAttribute("onlinenumber");
    	        //如果有用户访问，我们就把计数器加1
    	        if(user!=null){
    	        int new_online=old_online+1;
    	        application.setAttribute("onlinenumber", new_online);
    	        System.out.println("新的在线人数"+new_online);
    	        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
