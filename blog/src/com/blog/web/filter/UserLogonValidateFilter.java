package com.blog.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.bean.user.User;
import com.blog.utils.WebUtil;

public class UserLogonValidateFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		User user=WebUtil.getUser(req);
		if(user==null){
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("/user/logon.do");
		}else{
			chain.doFilter(request, response);
		}
	}
	
	public void destroy() {
		System.out.println("过滤器销毁");
	}

	

}
