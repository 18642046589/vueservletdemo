package com.neuedu.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.Goods;
import com.neuedu.service.IGoodsService;
import com.neuedu.utils.UUIDUtil;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/admin/addGoodsServlet")
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGoodsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsNumber = request.getParameter("goodsNumber");
		String cateId=request.getParameter("cateId");
		// 获取上传的文件集合
		Part file=request.getPart("goodsPic");//单个文件
		String old_file=file.getSubmittedFileName();
		//为图片指定存储的文件夹
		String savePath = request.getServletContext().getRealPath("/upload");
		//为新上传的图片重新生成一个文件名字
		String preffix=UUIDUtil.generateUUID();//32位的文件名字
		String suffix = old_file.substring(old_file.lastIndexOf("."));//获取原始文件的后缀
	    //用上面的三个路径和文件名，拼成完成的文件路径 
		//d:/study/webContent/upload/*******.JPG
		String filename=preffix+suffix;//把图片名字存到库里
		String path=savePath+File.separator+filename;
		System.out.println(path);
		//把文件存储到硬盘
		file.write(path);
		// TODO 把文件全路径存到数据库的表里
		//先封装一个对象
		Goods goods=new Goods();
		goods.setCateid(Integer.parseInt(cateId));
		goods.setFilename(filename);
		goods.setGoodsName(goodsName);
		goods.setGoodsNumber(Integer.parseInt(goodsNumber));
		goods.setGoodsPrice(Float.parseFloat(goodsPrice));
		//把对象传给service,让它处理
		IGoodsService goodsServie=new GoodsServiceImpl();
		try {
			int result=goodsServie.save(goods);
			if(result>0){
				request.getRequestDispatcher("/admin/preAddGoodsServlet").forward(request, response);
			}
		} catch (DbException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
