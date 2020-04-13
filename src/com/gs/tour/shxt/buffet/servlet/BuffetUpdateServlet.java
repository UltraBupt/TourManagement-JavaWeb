package com.gs.tour.shxt.buffet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.buffet.model.Buffet;
import com.gs.tour.shxt.buffet.service.BuffetService;

/**
 * Servlet implementation class BuffetUpdateServlet
 */
@WebServlet("/BuffetUpdateServlet.shxt")
public class BuffetUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buffet_id=request.getParameter("buffet_id");
		BuffetService buffetService=new BuffetService();
		request.setAttribute("buffet",buffetService.load(Integer.parseInt(buffet_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/buffet/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buffet_name=request.getParameter("buffet_name");
		String buffet_price=request.getParameter("buffet_price");
		String buffet_address=request.getParameter("buffet_address");
		String buffet_desc=request.getParameter("buffet_desc");
		String buffet_id=request.getParameter("buffet_id");
		Buffet buffet=new Buffet();
		buffet.setBuffet_name(buffet_name);
		buffet.setBuffet_price(buffet_price);
		buffet.setBuffet_address(buffet_address);
		buffet.setBuffet_desc(buffet_desc);
		buffet.setBuffet_id(Integer.parseInt(buffet_id));
		BuffetService buffetService=new BuffetService();
		buffetService.update(buffet);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
