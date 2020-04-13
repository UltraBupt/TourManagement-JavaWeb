package com.gs.tour.shxt.advertisement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.advertisement.service.AdvertisementService;

/**
 * Servlet implementation class AdvertisementListServlet
 */
@WebServlet("/AdvertisementListServlet.shxt")
public class AdvertisementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdvertisementService advertisementService=new AdvertisementService();
		request.setAttribute("advertisement", advertisementService.getAllAdvertisementList());
		request.getRequestDispatcher("WEB-INF/jsp/advertisement/advertisement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
