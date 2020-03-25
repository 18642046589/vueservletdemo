package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/admin/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取用户输入
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String birthday=request.getParameter("birthday");
		String id=request.getParameter("id");
		String role=request.getParameter("role");
		
		//把上述信息封装到对象里，调用service方法进行修改数据库中相应记录的操作
		User u=new User();
		u.setId(Integer.parseInt(id));
		u.setEmail(email);
		u.setPhone(phone);
		u.setBirthday(birthday);
		u.setUserName(username);
		u.setRole(role);
		
		IUserService us=new UserServiceImpl();
		try {
			int result=us.updateUser(u);
			if(result>0){
				//如果修改成功，需要更新一下session
				HttpSession session=request.getSession();
				session.setAttribute("loginUser", u);
				//设置session超时时间，以秒为单位
				session.setMaxInactiveInterval(30*60);
				 //修改成功回修改页
				
			}else{
				request.setAttribute("resultMsg", "修改失败");
			}
			
		} catch (DbException | SQLException e) {
			request.setAttribute("resultMsg", "操作异常");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/updateuser.jsp").forward(request, response);
		
	}

}
