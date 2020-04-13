package com.gs.tour.shxt.apartment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.apartment.model.Apartment;
import com.gs.tour.shxt.apartment.service.ApartmentService;
import com.gs.tour.shxt.base.model.PageBean;

/**
 * Servlet implementation class ApartmentServlet
 */
@WebServlet("/ApartmentServlet.shxt")
public class ApartmentServlet extends HttpServlet {
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
		String apartment_name=request.getParameter("apartment_name");
		String apartment_status=request.getParameter("apartment_status");
		Apartment apartment=new Apartment();
		if(apartment_name!=null&&apartment_name.trim().length()>0){
			apartment.setApartment_name(apartment_name);
		}
		if(apartment_status!=null&&apartment_status.trim().length()>0){
			apartment.setApartment_status(Integer.parseInt(apartment_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		ApartmentService apartmentService=new ApartmentService();
		request.setAttribute("pageBean", apartmentService.getAllApartmentList(apartment, pageBean));
		request.setAttribute("queryApartment", apartment);
		request.getRequestDispatcher("WEB-INF/jsp/apartment/list.jsp").forward(request, response);
	}

}
