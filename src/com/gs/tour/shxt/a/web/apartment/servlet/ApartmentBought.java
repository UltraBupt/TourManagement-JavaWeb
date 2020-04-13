package com.gs.tour.shxt.a.web.apartment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.apartment.service.WebApartmentService;

/**
 * Servlet implementation class ApartmentBought
 */
@WebServlet("/ApartmentBought.html")
public class ApartmentBought extends HttpServlet {
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
		String apartment_id=request.getParameter("apartment_id");
		WebApartmentService webApartmentServcie=new WebApartmentService();
		request.setAttribute("apartment", webApartmentServcie.queryApartmentByApartmentId(Integer.parseInt(apartment_id)));
		request.getRequestDispatcher("WEB-INF/web/apartment/apartmentBought.jsp").forward(request, response);
	}

}
