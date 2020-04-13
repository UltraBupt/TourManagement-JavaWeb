package com.gs.tour.shxt.ship.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.ship.model.Ship;
import com.gs.tour.shxt.ship.service.ShipService;
import com.gs.tour.shxt.base.model.PageBean;

/**
 * Servlet implementation class ShipServlet
 */
@WebServlet("/ShipServlet.shxt")
public class ShipServlet extends HttpServlet {
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
		String ship_point=request.getParameter("ship_point");
		String ship_status=request.getParameter("ship_status");
		Ship ship=new Ship();
		if(ship_point!=null&&ship_point.trim().length()>0){
			ship.setShip_point(ship_point);
		}
		if(ship_status!=null&&ship_status.trim().length()>0){
			ship.setShip_status(Integer.parseInt(ship_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		ShipService shipService=new ShipService();
		request.setAttribute("pageBean", shipService.getAllShipList(ship, pageBean));
		request.setAttribute("queryShip", ship);
		request.getRequestDispatcher("WEB-INF/jsp/ship/list.jsp").forward(request, response);
	}

}
