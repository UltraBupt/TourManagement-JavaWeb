package com.gs.tour.shxt.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.airline.model.Airline;
import com.gs.tour.shxt.airline.service.AirlineService;

/**
 * Servlet implementation class AirlineAddServlet
 */
@WebServlet("/AirlineAddServlet.shxt")
public class AirlineAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/airline/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String airline_from=request.getParameter("airline_from");
		String airline_to=request.getParameter("airline_to");
		String airline_price=request.getParameter("airline_price");
		String airline_time=request.getParameter("airline_time");
		String airline_point=request.getParameter("airline_point");
		Airline airline=new Airline();
		airline.setAirline_from(airline_from);
		airline.setAirline_to(airline_to);
		airline.setAirline_price(airline_price);
		airline.setAirline_time(airline_time);
		airline.setAirline_point(airline_point);
		AirlineService airlineService=new AirlineService();
		try {
			airlineService.addAirline(airline);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
