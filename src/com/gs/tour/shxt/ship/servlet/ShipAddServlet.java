package com.gs.tour.shxt.ship.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.ship.model.Ship;
import com.gs.tour.shxt.ship.service.ShipService;

/**
 * Servlet implementation class ShipAddServlet
 */
@WebServlet("/ShipAddServlet.shxt")
public class ShipAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/ship/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ship_from=request.getParameter("ship_from");
		String ship_to=request.getParameter("ship_to");
		String ship_price=request.getParameter("ship_price");
		String ship_time=request.getParameter("ship_time");
		String ship_point=request.getParameter("ship_point");
		Ship ship=new Ship();
		ship.setShip_from(ship_from);
		ship.setShip_to(ship_to);
		ship.setShip_price(ship_price);
		ship.setShip_time(ship_time);
		ship.setShip_point(ship_point);
		ShipService shipService=new ShipService();
		try {
			shipService.addShip(ship);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
