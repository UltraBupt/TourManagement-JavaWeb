package com.gs.tour.shxt.a.web.tour.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutboundTicketBought
 */
@WebServlet("/OutboundTicketBought.html")
public class OutboundTicketBought extends HttpServlet {
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
		String outboundTicket_url=request.getParameter("outboundTicket_url");
		String outboundTicket_price=request.getParameter("outboundTicket_price");
		String outboundTicket_desc=request.getParameter("outboundTicket_desc");
		request.setAttribute("outboundTicket_url", outboundTicket_url);
		request.setAttribute("outboundTicket_price", outboundTicket_price);
		request.setAttribute("outboundTicket_desc", outboundTicket_desc);
		request.getRequestDispatcher("WEB-INF/web/tour/outboundTicketBought.jsp").forward(request, response);
	}

}
