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
 * Servlet implementation class ApartmentUpdateServlet
 */
@WebServlet("/ApartmentUpdateServlet.shxt")
public class ApartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apartment_id=request.getParameter("apartment_id");
		ApartmentService apartmentService=new ApartmentService();
		request.setAttribute("apartment",apartmentService.load(Integer.parseInt(apartment_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/apartment/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apartment_name=request.getParameter("apartment_name");
		String apartment_price=request.getParameter("apartment_price");
		String apartment_address=request.getParameter("apartment_address");
		String apartment_desc=request.getParameter("apartment_desc");
		String apartment_id=request.getParameter("apartment_id");
		Apartment apartment=new Apartment();
		apartment.setApartment_name(apartment_name);
		apartment.setApartment_price(apartment_price);
		apartment.setApartment_address(apartment_address);
		apartment.setApartment_desc(apartment_desc);
		apartment.setApartment_id(Integer.parseInt(apartment_id));
		ApartmentService apartmentService=new ApartmentService();
		apartmentService.update(apartment);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
