package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
/*@WebServlet("/registerServlet")*/
@WebServlet(value="/user/registerServlet",initParams={@WebInitParam(name="encode",value="utf-8")})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	

	

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * 初始化方法
     */
    @Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化方法");
		System.out.println(config.getInitParameter("encode"));
		super.init(config);
	}
    /**
     * 中间服务方法
     */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service方法");
		super.service(arg0, arg1);
	}
    /**
     * 销毁方法
     */
	@Override
	public void destroy() {
		System.out.println("destroy方法");
		super.destroy();
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet方法");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request常用信息
		/*System.out.println("getContextPath："+request.getContextPath());//上下文信息   工程名字
		System.out.println("getRemoteHost："+request.getRemoteHost());//客户端的IP地址
		System.out.println("getRemotePort："+request.getRemotePort());//客户端的端口
		System.out.println("getMethod："+request.getMethod());//客户端请求方法 
		//以下了解
		System.out.println("getRemoteAddr："+request.getRemoteAddr());//客户端的IP地址
		System.out.println("getLocalAddr："+request.getLocalAddr());
		System.out.println("getLocalPort："+request.getLocalPort());
		System.out.println("getRequestURI："+request.getRequestURI());
		
		System.out.println("以下是头部信息");
		Enumeration<String> headers=request.getHeaderNames();
		while(headers.hasMoreElements()){
	        String key=headers.nextElement();
	        String value=request.getHeader(key);
	        System.out.println("key--->"+key);
	        System.out.println("value--->"+value);
	        
	    }
		*/
		//以下是response
		
		//指定请求编码方式为utf-8
		//request.setCharacterEncoding("utf-8");
		//指定响应编码方式为utf-8
		//response.setCharacterEncoding("utf-8");
		//告诉浏览器我给你返回的是html，编码方式为utf-8
		
		System.out.println("doPost");
		//依次获取前台输入的内容
		//用户名
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String birthday=request.getParameter("user_date");
		
		//String[] hobbys=request.getParameterValues("hobby");
		//把用户输入的东西进行打包
		User user=new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setBirthday(birthday);
		user.setEmail(email);
		
		//调用service dao进行业务处理  servlet---service---dao
		IUserService service=new UserServiceImpl();
		//注册其实是向数据库进行的添加操作,往数据库添加会返回int
		try {
			//把打包的东西交由servcie进行处理
			int result=service.save(user);
			//如果注册成功，跳转到登录页
			//如果注册失败或者系统异常，回注册页
			if(result>0){
				//response.getWriter().append("成功");
				//利用响应重定向技术，回到登录页
				response.sendRedirect(request.getContextPath()+"/login.html");
				//利用请求转发技术，回到登录页
				//request.getRequestDispatcher("/login.html").forward(request, response);
			}else{
				//
				response.getWriter().append("失败");
			}
		} catch (DbException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append("失败");
		}
		
	}

}
