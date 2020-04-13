package com.gs.tour.shxt.outboundticket.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.outboundticket.model.OutboundTicket;
import com.gs.tour.shxt.outboundticket.service.OutboundTicketService;

/**
 * Servlet implementation class OutboundTicketUpdateServlet
 */
@WebServlet("/OutboundTicketUpdateServlet.shxt")
public class OutboundTicketUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outboundTicket_id=request.getParameter("outboundTicket_id");
		OutboundTicketService outboundTicketService=new OutboundTicketService();
		request.setAttribute("outboundTicket", outboundTicketService.load(Integer.parseInt(outboundTicket_id)));
		request.getRequestDispatcher("WEB-INF/jsp/outboundTicket/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outboundTicket_id=request.getParameter("outboundTicket_id");
		String outboundTicket_desc=request.getParameter("outboundTicket_desc");
		String outboundTicket_price=request.getParameter("outboundTicket_price");
		OutboundTicket outboundTicket=new OutboundTicket();
		outboundTicket.setOutboundTicket_desc(outboundTicket_desc);
		outboundTicket.setOutboundTicket_id(Integer.parseInt(outboundTicket_id));
		outboundTicket.setOutboundTicket_price(outboundTicket_price);
		OutboundTicketService outboundTicketService=new OutboundTicketService();
		outboundTicketService.update(outboundTicket);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
