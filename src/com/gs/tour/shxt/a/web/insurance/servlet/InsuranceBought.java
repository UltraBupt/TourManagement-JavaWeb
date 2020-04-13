package com.gs.tour.shxt.a.web.insurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.insurance.service.WebInsuranceService;

/**
 * Servlet implementation class InsuranceBought
 */
@WebServlet("/InsuranceBought.html")
public class InsuranceBought extends HttpServlet {
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
		String insurance_id=request.getParameter("insurance_id");
		WebInsuranceService webInsuranceServcie=new WebInsuranceService();
		request.setAttribute("insurance", webInsuranceServcie.queryInsuranceByInsuranceId(Integer.parseInt(insurance_id)));
		request.getRequestDispatcher("WEB-INF/web/insurance/insuranceBought.jsp").forward(request, response);
	}

}
