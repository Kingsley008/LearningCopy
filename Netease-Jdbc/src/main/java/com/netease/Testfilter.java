package com.netease;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Testfilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//String value = filterConfig.getInitParameter("filterParam");
     //System.out.println("filter init "+value);
	}

	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 先进行转换
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null){
			//判断session中是否有user这个属性 
			//如果没有将这个用户视为非法用户，并提示用户先登录
			HttpServletResponse res = (HttpServletResponse) response;
			//将提示带回主页面,1表示还没有登入
			res.sendRedirect("index.jsp?err=1");
		}else{
			chain.doFilter(request, response);
		}
		System.out.println("filter doFilter ");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter destroy ");
	}
}
