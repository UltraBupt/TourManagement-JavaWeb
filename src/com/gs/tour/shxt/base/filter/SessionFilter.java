package com.gs.tour.shxt.base.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession session=request.getSession();
		String path=request.getServletPath();
		if(path.endsWith("LoginServlet.shxt")){
			chain.doFilter(req, resp);
		}else{
			if(session.getAttribute("session_user")!=null){
				chain.doFilter(req, resp);
			}else{
				/*如果不是通过登录界面跳转过来的就提示登陆超时*/
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.write("<script>alert('登录超时，请重新登陆');window.top.location.href='/shxt/LoginServlet.shxt';</script>");
				out.flush();
				out.close();
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
