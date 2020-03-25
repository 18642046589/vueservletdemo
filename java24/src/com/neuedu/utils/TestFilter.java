package com.neuedu.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// 初始化方法  准备工作

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//中间服务方法  业务
		//我们要做的是拦截请求和响应，做请求响应的编码处理，utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//放行,如果不放行，请求将无法到达请求地址
		chain.doFilter(request, response);

	}
	@Override
	public void destroy() {
		//销毁的方法  清理工作

	}

	

	

}
