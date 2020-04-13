package com.gs.tour.shxt.holiday.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.holiday.model.Holiday;
import com.gs.tour.shxt.holiday.service.HolidayService;

/**
 * Servlet implementation class HolidayServlet
 */
@WebServlet("/HolidayServlet.shxt")
public class HolidayServlet extends HttpServlet {
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
		String holiday_name=request.getParameter("holiday_name");
		String holiday_status=request.getParameter("holiday_status");
		Holiday holiday=new Holiday();
		if(holiday_name!=null&&holiday_name.trim().length()>0){
			holiday.setHoliday_name(holiday_name);
		}
		if(holiday_status!=null&&holiday_status.trim().length()>0){
			holiday.setHoliday_status(Integer.parseInt(holiday_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		HolidayService holidayService=new HolidayService();
		request.setAttribute("pageBean", holidayService.getAllHolidayList(holiday, pageBean));
		request.setAttribute("queryHoliday", holiday);
		request.getRequestDispatcher("WEB-INF/jsp/holiday/list.jsp").forward(request, response);
	}

}
