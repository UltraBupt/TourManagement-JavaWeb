package com.gs.tour.shxt.hotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.hotel.model.Hotel;
import com.gs.tour.shxt.hotel.service.HotelService;

/**
 * Servlet implementation class HotelAddServlet
 */
@WebServlet("/HotelAddServlet.shxt")
public class HotelAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/hotel/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotel_name=request.getParameter("hotel_name");
		String hotel_price=request.getParameter("hotel_price");
		String hotel_address=request.getParameter("hotel_address");
		String hotel_desc=request.getParameter("hotel_desc");
		Hotel hotel=new Hotel();
		hotel.setHotel_name(hotel_name);
		hotel.setHotel_price(hotel_price);
		hotel.setHotel_address(hotel_address);
		hotel.setHotel_desc(hotel_desc);
		HotelService hotelService=new HotelService();
		try {
			hotelService.addHotel(hotel);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
