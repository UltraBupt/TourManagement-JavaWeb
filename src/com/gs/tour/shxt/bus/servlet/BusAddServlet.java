package com.gs.tour.shxt.bus.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.bus.model.Bus;
import com.gs.tour.shxt.bus.service.BusService;

/**
 * Servlet implementation class BusAddServlet
 */
@WebServlet("/BusAddServlet.shxt")
public class BusAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/bus/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bus_from=request.getParameter("bus_from");
		String bus_to=request.getParameter("bus_to");
		String bus_price=request.getParameter("bus_price");
		String bus_time=request.getParameter("bus_time");
		String bus_point=request.getParameter("bus_point");
		Bus bus=new Bus();
		bus.setBus_from(bus_from);
		bus.setBus_to(bus_to);
		bus.setBus_price(bus_price);
		bus.setBus_time(bus_time);
		bus.setBus_point(bus_point);
		BusService busService=new BusService();
		try {
			busService.addBus(bus);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
