package com.gs.tour.shxt.hotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.hotel.model.Hotel;
import com.gs.tour.shxt.hotel.service.HotelService;

/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("/HotelServlet.shxt")
public class HotelServlet extends HttpServlet {
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
		String hotel_name=request.getParameter("hotel_name");
		String hotel_status=request.getParameter("hotel_status");
		Hotel hotel=new Hotel();
		if(hotel_name!=null&&hotel_name.trim().length()>0){
			hotel.setHotel_name(hotel_name);
		}
		if(hotel_status!=null&&hotel_status.trim().length()>0){
			hotel.setHotel_status(Integer.parseInt(hotel_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		HotelService hotelService=new HotelService();
		request.setAttribute("pageBean", hotelService.getAllHotelList(hotel, pageBean));
		request.setAttribute("queryHotel", hotel);
		request.getRequestDispatcher("WEB-INF/jsp/hotel/list.jsp").forward(request, response);
	}

}
