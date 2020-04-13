package com.gs.tour.shxt.a.web.bus.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.bus.service.WebBusService;

/**
 * Servlet implementation class BusBought
 */
@WebServlet("/BusBought.html")
public class BusBought extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bus_id=request.getParameter("bus_id");
		WebBusService webBusServcie=new WebBusService();
		request.setAttribute("bus", webBusServcie.queryBusByBusId(Integer.parseInt(bus_id)));
		request.getRequestDispatcher("WEB-INF/web/bus/busBought.jsp").forward(request, response);
	}

}
