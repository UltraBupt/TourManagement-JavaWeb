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
 * Servlet implementation class BuffetAddServlet
 */
@WebServlet("/BuffetAddServlet.shxt")
public class BuffetAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/buffet/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buffet_name=request.getParameter("buffet_name");
		String buffet_price=request.getParameter("buffet_price");
		String buffet_address=request.getParameter("buffet_address");
		String buffet_desc=request.getParameter("buffet_desc");
		Buffet buffet=new Buffet();
		buffet.setBuffet_name(buffet_name);
		buffet.setBuffet_price(buffet_price);
		buffet.setBuffet_address(buffet_address);
		buffet.setBuffet_desc(buffet_desc);
		BuffetService buffetService=new BuffetService();
		try {
			buffetService.addBuffet(buffet);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
