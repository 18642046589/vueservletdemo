package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.exception.DbException;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DelAllServlet
 */
@WebServlet("/admin/delAllServlet")
public class DelAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelAllServlet() {
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
		//获取用户要删除的id集合
		String[] ids=request.getParameterValues("chkone");//可以获取checkbox的值，是字符串数组
		System.out.println(ids);
		//调用service进行批量删除
		IUserService us=new UserServiceImpl();
		int result=0;
			try {
				result = us.delByIds(ids);
			} catch (DbException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 request.setAttribute("resultMsg", "数据库异常");
			}
	     if(result>0){
	    	 request.setAttribute("resultMsg", "成功");
	     }else{
	    	 request.setAttribute("resultMsg", "失败");
	     }
	     request.getRequestDispatcher("/admin/findAllUserServlet?pageSize=10&currentPage=1").forward(request, response);
	}

}
