package com.gs.tour.shxt.a.web.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.airline.service.WebAirlineService;

/**
 * Servlet implementation class AirlineBought
 */
@WebServlet("/AirlineBought.html")
public class AirlineBought extends HttpServlet {
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
		String airline_id=request.getParameter("airline_id");
		WebAirlineService webAirlineServcie=new WebAirlineService();
		request.setAttribute("airline", webAirlineServcie.queryAirlineByAirlineId(Integer.parseInt(airline_id)));
		request.getRequestDispatcher("WEB-INF/web/airline/airlineBought.jsp").forward(request, response);
	}

}
