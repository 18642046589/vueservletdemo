package com.neuedu.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		response.setContentType("text/html;charset=utf-8");
        //设置存储路径
        //生产环境
        String savePath = request.getServletContext().getRealPath("/upload");
        //开发环境
        //String savePath = "D:/apache-tomcat-8.0.36/wtpwebapps/upload";
        String name=request.getParameter("name");
        Part part = request.getPart("f1");
        //自定义编写解析字符串的方法getFileName，获取文件名
        String oriFileName = part.getSubmittedFileName();//调用获取文件名的方法
        
        if(oriFileName.endsWith("JPG") || oriFileName.endsWith("PNG") || oriFileName.endsWith("jpg")|| oriFileName.endsWith("png")) {
            //获取原文件名后缀
            String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
            //避免上传后文件名称重复，使用uuid文件名
            String fileName="mypic";
            fileName = fileName + suffix;
            // 把文件写到指定路径
            part.write(savePath + File.separator +fileName);
            PrintWriter out = response.getWriter();
            request.setAttribute("msg","上传成功"); 
            request.getRequestDispatcher("upload.jsp").forward(request, response);
        }else {
            request.setAttribute("msg","请上传图片类型的文件！");  
            request.getRequestDispatcher("upload.jsp").forward(request, response);
        }
	}

}
