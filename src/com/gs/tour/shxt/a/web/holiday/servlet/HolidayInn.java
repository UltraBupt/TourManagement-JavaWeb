package com.gs.tour.shxt.a.web.holiday.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.holiday.service.WebHolidayService;

/**
 * Servlet implementation class HolidayInn
 */
@WebServlet("/HolidayInn.html")
public class HolidayInn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebHolidayService webHolidayService=new WebHolidayService();
		request.setAttribute("holiday", webHolidayService.getHolidayList());
		request.getRequestDispatcher("WEB-INF/web/holiday/holiday.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
