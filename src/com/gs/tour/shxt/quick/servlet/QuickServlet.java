package com.gs.tour.shxt.quick.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.quick.model.Quick;
import com.gs.tour.shxt.quick.service.QuickService;

/**
 * Servlet implementation class QuickServlet
 */
@WebServlet("/QuickServlet.shxt")
public class QuickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String quick_name=request.getParameter("quick_name");
		String quick_status=request.getParameter("quick_status");
		Quick quick=new Quick();
		if(quick_name!=null&&quick_name.trim().length()>0){
			quick.setQuick_name(quick_name);
		}
		if(quick_status!=null&&quick_status.trim().length()>0){
			quick.setQuick_status(Integer.parseInt(quick_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		QuickService quickService=new QuickService();
		request.setAttribute("pageBean", quickService.getAllQuickList(quick, pageBean));
		request.setAttribute("queryQuick", quick);
		request.getRequestDispatcher("WEB-INF/jsp/quick/list.jsp").forward(request, response);
	}

}
