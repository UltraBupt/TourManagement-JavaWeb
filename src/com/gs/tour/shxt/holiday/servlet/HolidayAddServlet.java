package com.gs.tour.shxt.holiday.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.holiday.model.Holiday;
import com.gs.tour.shxt.holiday.service.HolidayService;

/**
 * Servlet implementation class HolidayAddServlet
 */
@WebServlet("/HolidayAddServlet.shxt")
public class HolidayAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/holiday/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String holiday_name=request.getParameter("holiday_name");
		String holiday_price=request.getParameter("holiday_price");
		String holiday_address=request.getParameter("holiday_address");
		String holiday_desc=request.getParameter("holiday_desc");
		Holiday holiday=new Holiday();
		holiday.setHoliday_name(holiday_name);
		holiday.setHoliday_price(holiday_price);
		holiday.setHoliday_address(holiday_address);
		holiday.setHoliday_desc(holiday_desc);
		HolidayService holidayService=new HolidayService();
		try {
			holidayService.addHoliday(holiday);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
