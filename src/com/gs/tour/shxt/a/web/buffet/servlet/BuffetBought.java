package com.gs.tour.shxt.a.web.buffet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.buffet.service.WebBuffetService;

/**
 * Servlet implementation class BuffetBought
 */
@WebServlet("/BuffetBought.html")
public class BuffetBought extends HttpServlet {
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
		String buffet_id=request.getParameter("buffet_id");
		WebBuffetService webBuffetServcie=new WebBuffetService();
		request.setAttribute("buffet", webBuffetServcie.queryBuffetByBuffetId(Integer.parseInt(buffet_id)));
		request.getRequestDispatcher("WEB-INF/web/buffet/buffetBought.jsp").forward(request, response);
	}

}
