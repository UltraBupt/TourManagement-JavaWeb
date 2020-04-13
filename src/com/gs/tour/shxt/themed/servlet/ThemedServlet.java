package com.gs.tour.shxt.themed.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.themed.model.Themed;
import com.gs.tour.shxt.themed.service.ThemedService;

/**
 * Servlet implementation class ThemedServlet
 */
@WebServlet("/ThemedServlet.shxt")
public class ThemedServlet extends HttpServlet {
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
		String themed_name=request.getParameter("themed_name");
		String themed_status=request.getParameter("themed_status");
		Themed themed=new Themed();
		if(themed_name!=null&&themed_name.trim().length()>0){
			themed.setThemed_name(themed_name);
		}
		if(themed_status!=null&&themed_status.trim().length()>0){
			themed.setThemed_status(Integer.parseInt(themed_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		ThemedService themedService=new ThemedService();
		request.setAttribute("pageBean", themedService.getAllThemedList(themed, pageBean));
		request.setAttribute("queryThemed", themed);
		request.getRequestDispatcher("WEB-INF/jsp/themed/list.jsp").forward(request, response);
	}

}
