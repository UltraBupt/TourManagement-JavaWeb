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
 * Servlet implementation class HotelUpdateServlet
 */
@WebServlet("/HotelUpdateServlet.shxt")
public class HotelUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotel_id=request.getParameter("hotel_id");
		HotelService hotelService=new HotelService();
		request.setAttribute("hotel",hotelService.load(Integer.parseInt(hotel_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/hotel/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotel_name=request.getParameter("hotel_name");
		String hotel_price=request.getParameter("hotel_price");
		String hotel_address=request.getParameter("hotel_address");
		String hotel_desc=request.getParameter("hotel_desc");
		String hotel_id=request.getParameter("hotel_id");
		Hotel hotel=new Hotel();
		hotel.setHotel_name(hotel_name);
		hotel.setHotel_price(hotel_price);
		hotel.setHotel_address(hotel_address);
		hotel.setHotel_desc(hotel_desc);
		hotel.setHotel_id(Integer.parseInt(hotel_id));
		HotelService hotelService=new HotelService();
		hotelService.update(hotel);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
