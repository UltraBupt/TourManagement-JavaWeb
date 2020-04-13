package com.gs.tour.shxt.inboundticket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.inboundticket.model.InboundTicket;
import com.gs.tour.shxt.inboundticket.service.InboundTicketService;

/**
 * Servlet implementation class InboundTicketUpdateServlet
 */
@WebServlet("/InboundTicketUpdateServlet.shxt")
public class InboundTicketUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inboundTicket_id=request.getParameter("inboundTicket_id");
		InboundTicketService inboundTicketService=new InboundTicketService();
		request.setAttribute("inboundTicket", inboundTicketService.load(Integer.parseInt(inboundTicket_id)));
		request.getRequestDispatcher("WEB-INF/jsp/inboundTicket/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inboundTicket_id=request.getParameter("inboundTicket_id");
		String inboundTicket_desc=request.getParameter("inboundTicket_desc");
		String inboundTicket_price=request.getParameter("inboundTicket_price");
		InboundTicket inboundTicket=new InboundTicket();
		inboundTicket.setInboundTicket_desc(inboundTicket_desc);
		inboundTicket.setInboundTicket_id(Integer.parseInt(inboundTicket_id));
		inboundTicket.setInboundTicket_price(inboundTicket_price);
		InboundTicketService inboundTicketService=new InboundTicketService();
		inboundTicketService.update(inboundTicket);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
