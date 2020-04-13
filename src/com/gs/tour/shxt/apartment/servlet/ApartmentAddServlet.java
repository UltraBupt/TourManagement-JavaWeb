package com.gs.tour.shxt.apartment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.apartment.model.Apartment;
import com.gs.tour.shxt.apartment.service.ApartmentService;

/**
 * Servlet implementation class ApartmentAddServlet
 */
@WebServlet("/ApartmentAddServlet.shxt")
public class ApartmentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/apartment/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apartment_name=request.getParameter("apartment_name");
		String apartment_price=request.getParameter("apartment_price");
		String apartment_address=request.getParameter("apartment_address");
		String apartment_desc=request.getParameter("apartment_desc");
		Apartment apartment=new Apartment();
		apartment.setApartment_name(apartment_name);
		apartment.setApartment_price(apartment_price);
		apartment.setApartment_address(apartment_address);
		apartment.setApartment_desc(apartment_desc);
		ApartmentService apartmentService=new ApartmentService();
		try {
			apartmentService.addApartment(apartment);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
