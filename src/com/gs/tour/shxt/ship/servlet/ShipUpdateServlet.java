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
 * Servlet implementation class ShipUpdateServlet
 */
@WebServlet("/ShipUpdateServlet.shxt")
public class ShipUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ship_id=request.getParameter("ship_id");
		ShipService shipService=new ShipService();
		request.setAttribute("ship",shipService.load(Integer.parseInt(ship_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/ship/update.jsp").forward(request, response);
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
		String ship_id=request.getParameter("ship_id");
		Ship ship=new Ship();
		ship.setShip_from(ship_from);
		ship.setShip_to(ship_to);
		ship.setShip_price(ship_price);
		ship.setShip_time(ship_time);
		ship.setShip_point(ship_point);
		ship.setShip_id(Integer.parseInt(ship_id));
		ShipService shipService=new ShipService();
		shipService.update(ship);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
