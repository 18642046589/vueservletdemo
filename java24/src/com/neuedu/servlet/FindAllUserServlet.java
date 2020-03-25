package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.PageBean;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class FindAllUserServlet
 */
@WebServlet("/admin/findAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllUserServlet() {
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
		//请求和响应的编码解码
		//request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		//从前台获取当前请求页码和每页条数
		String currentPage=request.getParameter("currentPage");//当前面码
		String pageSize=request.getParameter("pageSize");//每页条数
		//step1 调用service的count，汇总一下总条数
		IUserService us=new UserServiceImpl();
		//select count(*) from t_user
		int count = 0;
		try {
			count = us.count();
		} catch (DbException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//step 2 新建一个pageBean，传到前台,供前台以后调用
		PageBean pb=new PageBean();
		pb.setPageSize(Integer.parseInt(pageSize));//
		pb.setCount(count);//需要查询数据库
		pb.setCurrentPage(Integer.parseInt(currentPage));
		request.setAttribute("page", pb);
		try {
			//调用service查询当前页用户 
			//改造findAll方法   当前索引：pageSize*(currentPage-1)
			List<User> userList=us.findAll(pb.getPageSize(),pb.getCurrentPage());
			//把用户信息放到request
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/admin/findall.jsp").forward(request, response);
		} catch (DbException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
