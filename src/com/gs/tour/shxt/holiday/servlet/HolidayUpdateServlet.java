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
 * Servlet implementation class HolidayUpdateServlet
 */
@WebServlet("/HolidayUpdateServlet.shxt")
public class HolidayUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String holiday_id=request.getParameter("holiday_id");
		HolidayService holidayService=new HolidayService();
		request.setAttribute("holiday",holidayService.load(Integer.parseInt(holiday_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/holiday/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String holiday_name=request.getParameter("holiday_name");
		String holiday_price=request.getParameter("holiday_price");
		String holiday_address=request.getParameter("holiday_address");
		String holiday_desc=request.getParameter("holiday_desc");
		String holiday_id=request.getParameter("holiday_id");
		Holiday holiday=new Holiday();
		holiday.setHoliday_name(holiday_name);
		holiday.setHoliday_price(holiday_price);
		holiday.setHoliday_address(holiday_address);
		holiday.setHoliday_desc(holiday_desc);
		holiday.setHoliday_id(Integer.parseInt(holiday_id));
		HolidayService holidayService=new HolidayService();
		holidayService.update(holiday);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
