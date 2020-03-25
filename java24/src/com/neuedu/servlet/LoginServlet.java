package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 1 请求和响应的编码方式
		//request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		//step 2 获取用户输入的用户名密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//是否记住用户名
		
       String flag=request.getParameter("flag");//如果被选中，传过来的值是1
       
       
		//step 3 让service去根据用户名密码查询数据库中的用户   ---》  
		// 只根据用户查询，如果能正常返回  用户名没错，
		IUserService us=new UserServiceImpl();
		try {
			User db_user=us.getUserByName(username);
			//null 真正的user
			if(db_user==null){
				//step 4如果没查询到，就回登录页，提示用户名错误
				System.out.println("用户名错误 ");
				//回登录页重新登录 TODO 应该带着错误信息
				//操作request的常用方法  getAttribute(读) setAttribute（后台放） removeAttribute（删除）
				request.setAttribute("resultMsg", "用户名错误 ");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				// 1 查询到了，我再比对密码  如果密码对不上，提示密码错
				if(db_user.getPassword().equals(password)){//用户名密码都正确
					//服务端把个人信息放到session(把从DB中查询到的user对象放到seession)
					//session在request
					HttpSession session=request.getSession();
					session.setAttribute("loginUser", db_user);
					//设置session超时时间，以秒为单位
					session.setMaxInactiveInterval(30*60);
					
					//做记住用户名功能
					if(flag!=null&&flag.equals("1")){//已勾选
						//新建cookie,将用户名信息存储到里面
						//public Cookie(java.lang.String name, java.lang.String value);
						Cookie c=new Cookie("username",username);
						//单位为秒
						c.setMaxAge(7*24*60*60);
						c.setPath("/");
						//给客户端发送一个存储cookie的命令
						response.addCookie(c);
						
						Cookie c2=new Cookie("password",password);
						//单位为秒
						c2.setMaxAge(7*24*60*60);
						c2.setPath("/");
						//给客户端发送一个存储cookie的命令
						response.addCookie(c2);
					}else{//没有勾选
						//新建cookie,将用户名信息存储到里面
						Cookie c=new Cookie("username",username);
						//单位为秒
						c.setMaxAge(0);//清除cookie
						c.setPath("/");
						//给客户端发送一个存储cookie的命令
						response.addCookie(c);
						
						Cookie c2=new Cookie("password",password);
						//单位为秒
						c2.setMaxAge(0);
						c2.setPath("/");
						//给客户端发送一个存储cookie的命令
						response.addCookie(c2);
					}
					
					//step 5 如果能查询到，我们需要判断用户权限  0-普通用户首页  1-管理员首页
					String role=db_user.getRole();//数据库中该用户我权限代码
					if(role.equals("0")){
						System.out.println("普通用户，进普通用户首页 ");
						response.sendRedirect(request.getContextPath()+"/user/index.html");
					}else if(role.equals("1")){
						System.out.println("管理员，进管理员首页 ");
						response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
					}
				}else{// 2 查询不到，密码错误
					System.out.println("密码错误 ");
					request.setAttribute("resultMsg", "密码错误 ");
					//回登录页重新登录
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}
			
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
