package com.gs.tour.shxt.a.web.tour.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AroundTicketBought
 */
@WebServlet("/AroundTicketBought.html")
public class AroundTicketBought extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aroundTicket_url=request.getParameter("aroundTicket_url");
		String aroundTicket_price=request.getParameter("aroundTicket_price");
		String aroundTicket_desc=request.getParameter("aroundTicket_desc");
		request.setAttribute("aroundTicket_url", aroundTicket_url);
		request.setAttribute("aroundTicket_price", aroundTicket_price);
		request.setAttribute("aroundTicket_desc", aroundTicket_desc);
		request.getRequestDispatcher("WEB-INF/web/tour/aroundTicketBought.jsp").forward(request, response);
	}

}
