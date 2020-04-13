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
 * Servlet implementation class AirlineUpdateServlet
 */
@WebServlet("/AirlineUpdateServlet.shxt")
public class AirlineUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String airline_id=request.getParameter("airline_id");
		AirlineService airlineService=new AirlineService();
		request.setAttribute("airline",airlineService.load(Integer.parseInt(airline_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/airline/update.jsp").forward(request, response);
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
		String airline_id=request.getParameter("airline_id");
		Airline airline=new Airline();
		airline.setAirline_from(airline_from);
		airline.setAirline_to(airline_to);
		airline.setAirline_price(airline_price);
		airline.setAirline_time(airline_time);
		airline.setAirline_point(airline_point);
		airline.setAirline_id(Integer.parseInt(airline_id));
		AirlineService airlineService=new AirlineService();
		airlineService.update(airline);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
