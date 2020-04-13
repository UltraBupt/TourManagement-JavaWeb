package com.gs.tour.shxt.western.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.western.model.Western;
import com.gs.tour.shxt.western.service.WesternService;

/**
 * Servlet implementation class WesternAddServlet
 */
@WebServlet("/WesternAddServlet.shxt")
public class WesternAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/western/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String western_name=request.getParameter("western_name");
		String western_price=request.getParameter("western_price");
		String western_address=request.getParameter("western_address");
		String western_desc=request.getParameter("western_desc");
		Western western=new Western();
		western.setWestern_name(western_name);
		western.setWestern_price(western_price);
		western.setWestern_address(western_address);
		western.setWestern_desc(western_desc);
		WesternService westernService=new WesternService();
		try {
			westernService.addWestern(western);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
