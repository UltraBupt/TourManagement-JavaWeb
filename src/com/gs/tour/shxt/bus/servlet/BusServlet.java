package com.gs.tour.shxt.bus.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.bus.model.Bus;
import com.gs.tour.shxt.bus.service.BusService;
import com.gs.tour.shxt.base.model.PageBean;

/**
 * Servlet implementation class BusServlet
 */
@WebServlet("/BusServlet.shxt")
public class BusServlet extends HttpServlet {
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
		String bus_point=request.getParameter("bus_point");
		String bus_status=request.getParameter("bus_status");
		Bus bus=new Bus();
		if(bus_point!=null&&bus_point.trim().length()>0){
			bus.setBus_point(bus_point);
		}
		if(bus_status!=null&&bus_status.trim().length()>0){
			bus.setBus_status(Integer.parseInt(bus_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		BusService busService=new BusService();
		request.setAttribute("pageBean", busService.getAllBusList(bus, pageBean));
		request.setAttribute("queryBus", bus);
		request.getRequestDispatcher("WEB-INF/jsp/bus/list.jsp").forward(request, response);
	}

}
