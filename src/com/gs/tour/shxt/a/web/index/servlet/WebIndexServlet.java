package com.gs.tour.shxt.a.web.index.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.advertisement.service.WebAdvertisementService;

/**
 * Servlet implementation class WebIndexServlet
 */
@WebServlet("/WebIndexServlet.html")
public class WebIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebAdvertisementService webAdvertisementService=new WebAdvertisementService();
		request.setAttribute("advertisement", webAdvertisementService.getAdvertisement());
		request.getRequestDispatcher("WEB-INF/web/index/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
