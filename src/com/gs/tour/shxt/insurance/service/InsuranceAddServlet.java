package com.gs.tour.shxt.insurance.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.insurance.model.Insurance;

/**
 * Servlet implementation class InsuranceAddServlet
 */
@WebServlet("/InsuranceAddServlet.shxt")
public class InsuranceAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/insurance/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String insurance_price=request.getParameter("insurance_price");
		String insurance_name=request.getParameter("insurance_name");
		String insurance_maxPrice=request.getParameter("insurance_maxPrice");
		String insurance_desc=request.getParameter("insurance_desc");
		Insurance insurance=new Insurance();
		insurance.setInsurance_price(insurance_price);
		insurance.setInsurance_name(insurance_name);
		insurance.setInsurance_maxPrice(insurance_maxPrice);
		insurance.setInsurance_desc(insurance_desc);
		InsuranceService insuranceService=new InsuranceService();
		try {
			insuranceService.addInsurance(insurance);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
