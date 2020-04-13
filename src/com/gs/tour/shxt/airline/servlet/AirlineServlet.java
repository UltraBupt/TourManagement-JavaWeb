package com.gs.tour.shxt.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.airline.model.Airline;
import com.gs.tour.shxt.airline.service.AirlineService;
import com.gs.tour.shxt.base.model.PageBean;

/**
 * Servlet implementation class AirlineServlet
 */
@WebServlet("/AirlineServlet.shxt")
public class AirlineServlet extends HttpServlet {
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
		String airline_point=request.getParameter("airline_point");
		String airline_status=request.getParameter("airline_status");
		Airline airline=new Airline();
		if(airline_point!=null&&airline_point.trim().length()>0){
			airline.setAirline_point(airline_point);
		}
		if(airline_status!=null&&airline_status.trim().length()>0){
			airline.setAirline_status(Integer.parseInt(airline_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		AirlineService airlineService=new AirlineService();
		request.setAttribute("pageBean", airlineService.getAllAirlineList(airline, pageBean));
		request.setAttribute("queryAirline", airline);
		request.getRequestDispatcher("WEB-INF/jsp/airline/list.jsp").forward(request, response);
	}

}
