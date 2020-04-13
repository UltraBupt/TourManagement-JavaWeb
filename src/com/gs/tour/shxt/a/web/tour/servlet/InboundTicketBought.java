package com.gs.tour.shxt.a.web.tour.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InboundTicketBought
 */
@WebServlet("/InboundTicketBought.html")
public class InboundTicketBought extends HttpServlet {
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
		String inboundTicket_url=request.getParameter("inboundTicket_url");
		String inboundTicket_price=request.getParameter("inboundTicket_price");
		String inboundTicket_desc=request.getParameter("inboundTicket_desc");
		request.setAttribute("inboundTicket_url", inboundTicket_url);
		request.setAttribute("inboundTicket_price", inboundTicket_price);
		request.setAttribute("inboundTicket_desc", inboundTicket_desc);
		request.getRequestDispatcher("WEB-INF/web/tour/inboundTicketBought.jsp").forward(request, response);
	}

}
