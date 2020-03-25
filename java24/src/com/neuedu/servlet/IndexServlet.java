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
import com.neuedu.pojo.Goods;
import com.neuedu.service.IGoodsService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//第一步  读取轮播图数据(读取cateid=3)
		IGoodsService gs=new GoodsServiceImpl();
		//findByCate(cateId)
	    List<Goods> adList;
		try {
			adList = gs.findByCate(3);
	    //放到请求里
	    request.setAttribute("adList", adList);
		//第二步 读取点击前10的商品
	    //findAll(当前页，每页几条)
	    List<Goods> hotList=gs.findAll(1,10);
		//放到请求里
	    request.setAttribute("hotList", hotList);
		} catch (DbException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//携带上述数据回前台首页
		request.getRequestDispatcher("/user/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
