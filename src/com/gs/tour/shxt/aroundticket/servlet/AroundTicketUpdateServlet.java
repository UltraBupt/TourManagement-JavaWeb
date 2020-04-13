package com.gs.tour.shxt.aroundticket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.tour.model.AroundTicket;
import com.gs.tour.shxt.aroundticket.service.AroundTicketService;


/**
 * Servlet implementation class AroundTicketUpdateServlet
 */
@WebServlet("/AroundTicketUpdateServlet.shxt")
public class AroundTicketUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aroundTicket_id=request.getParameter("aroundTicket_id");
		AroundTicketService aroundTicketService=new AroundTicketService();
		request.setAttribute("aroundTicket", aroundTicketService.load(Integer.parseInt(aroundTicket_id)));
		request.getRequestDispatcher("WEB-INF/jsp/aroundTicket/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aroundTicket_id=request.getParameter("aroundTicket_id");
		String aroundTicket_desc=request.getParameter("aroundTicket_desc");
		String aroundTicket_price=request.getParameter("aroundTicket_price");
		AroundTicket aroundTicket=new AroundTicket();
		aroundTicket.setAroundTicket_desc(aroundTicket_desc);
		aroundTicket.setAroundTicket_id(Integer.parseInt(aroundTicket_id));
		aroundTicket.setAroundTicket_price(aroundTicket_price);
		AroundTicketService aroundTicketService=new AroundTicketService();
		aroundTicketService.update(aroundTicket);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
