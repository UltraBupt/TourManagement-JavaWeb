package com.gs.tour.shxt.a.web.hotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.hotel.service.WebHotelService;

/**
 * Servlet implementation class HotelBought
 */
@WebServlet("/HotelBought.html")
public class HotelBought extends HttpServlet {
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
		String hotel_id=request.getParameter("hotel_id");
		WebHotelService webHotelServcie=new WebHotelService();
		request.setAttribute("hotel", webHotelServcie.queryHotelByHotelId(Integer.parseInt(hotel_id)));
		request.getRequestDispatcher("WEB-INF/web/hotel/hotelBought.jsp").forward(request, response);
	}

}
