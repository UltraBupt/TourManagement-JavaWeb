package com.gs.tour.shxt.a.web.holiday.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.holiday.service.WebHolidayService;

/**
 * Servlet implementation class HolidayBought
 */
@WebServlet("/HolidayBought.html")
public class HolidayBought extends HttpServlet {
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
		String holiday_id=request.getParameter("holiday_id");
		WebHolidayService webHolidayServcie=new WebHolidayService();
		request.setAttribute("holiday", webHolidayServcie.queryHolidayByHolidayId(Integer.parseInt(holiday_id)));
		request.getRequestDispatcher("WEB-INF/web/holiday/holidayBought.jsp").forward(request, response);
	}

}
