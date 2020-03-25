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
import com.neuedu.pojo.Cate;
import com.neuedu.service.ICateService;
import com.neuedu.service.impl.CateServiceImpl;

/**
 * Servlet implementation class PreAddGoodsServlet
 */
@WebServlet("/admin/preAddGoodsServlet")
public class PreAddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreAddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//读取分类信息，并传给addgoods.jsp
		ICateService cs=new CateServiceImpl();
		List<Cate> cateList=null;
		try {
			cateList = cs.findAll();
		} catch (DbException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cateList", cateList);
		request.getRequestDispatcher("/admin/addgoods.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
