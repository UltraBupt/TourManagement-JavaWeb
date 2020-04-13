package com.gs.tour.shxt.a.web.insurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.insurance.service.WebInsuranceService;

/**
 * Servlet implementation class Insurance
 */
@WebServlet("/Insurance.html")
public class Insurance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebInsuranceService webInsuranceService=new WebInsuranceService();
		request.setAttribute("insurance", webInsuranceService.getInsuranceList());
		request.getRequestDispatcher("WEB-INF/web/insurance/insurance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
