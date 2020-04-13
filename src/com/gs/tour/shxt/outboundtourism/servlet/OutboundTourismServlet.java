package com.gs.tour.shxt.outboundtourism.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.outboundtourism.service.OutboundTourismService;

/**
 * Servlet implementation class OutboundTourismServlet
 */
@WebServlet("/OutboundTourismServlet.shxt")
public class OutboundTourismServlet extends HttpServlet {
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
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		OutboundTourismService outboundTourismService=new OutboundTourismService();
		request.setAttribute("pageBean", outboundTourismService.getAllOutboundTourismList(pageBean));
		request.getRequestDispatcher("WEB-INF/jsp/outboundTourism/list.jsp").forward(request, response);
	}

}
