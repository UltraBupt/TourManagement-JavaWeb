package com.gs.tour.shxt.buffet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.buffet.model.Buffet;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.buffet.service.BuffetService;

/**
 * Servlet implementation class BuffetServlet
 */
@WebServlet("/BuffetServlet.shxt")
public class BuffetServlet extends HttpServlet {
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
		String buffet_name=request.getParameter("buffet_name");
		String buffet_status=request.getParameter("buffet_status");
		Buffet buffet=new Buffet();
		if(buffet_name!=null&&buffet_name.trim().length()>0){
			buffet.setBuffet_name(buffet_name);
		}
		if(buffet_status!=null&&buffet_status.trim().length()>0){
			buffet.setBuffet_status(Integer.parseInt(buffet_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		BuffetService buffetService=new BuffetService();
		request.setAttribute("pageBean", buffetService.getAllBuffetList(buffet, pageBean));
		request.setAttribute("queryBuffet", buffet);
		request.getRequestDispatcher("WEB-INF/jsp/buffet/list.jsp").forward(request, response);
	}

}
