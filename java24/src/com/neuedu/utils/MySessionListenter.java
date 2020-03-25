package com.neuedu.utils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.neuedu.pojo.User;

/**
 * Application Lifecycle Listener implementation class MySessionListenter
 *
 */
@WebListener
public class MySessionListenter implements HttpSessionListener,HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MySessionListenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
         System.out.println("sessionCreated建立");
         //从session/request里都可以得到ServletContext--->sessionEvent.getSession可以获取
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent sessionEvent)  { 
    	 System.out.println("sessionDestroyed");
         //从session/request里都可以得到ServletContext--->sessionEvent.getSession可以获取
         HttpSession session=sessionEvent.getSession();
         ServletContext application= session.getServletContext();
         int old_online=(Integer)application.getAttribute("onlinenumber");
         //如果有用户访问，我们就把计数器加1
         int new_online=old_online-1;
         application.setAttribute("onlinenumber", new_online);
         System.out.println("新的在线人数"+new_online);
    	//如果有用户退出或超时，我们就把计数器-1
    }

	@Override
	public void attributeAdded(HttpSessionBindingEvent sessionEvent) {
		/*// TODO Auto-generated method stub
		User user=(User)sessionEvent.getSession().getAttribute("loginUser");
		HttpSession session=sessionEvent.getSession();
        ServletContext application= session.getServletContext();
        int old_online=(Integer)application.getAttribute("onlinenumber");
        //如果有用户访问，我们就把计数器加1
        if(user!=null){
        int new_online=old_online+1;
        application.setAttribute("onlinenumber", new_online);
        System.out.println("新的在线人数"+new_online);
        }*/
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
