package com.gs.tour.shxt.insurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.insurance.model.Insurance;
import com.gs.tour.shxt.insurance.service.InsuranceService;

/**
 * Servlet implementation class InsuranceUpdateServlet
 */
@WebServlet("/InsuranceUpdateServlet.shxt")
public class InsuranceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String insurance_id=request.getParameter("insurance_id");
		InsuranceService insuranceService=new InsuranceService();
		request.setAttribute("insurance",insuranceService.load(Integer.parseInt(insurance_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/insurance/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String insurance_price=request.getParameter("insurance_price");
		String insurance_name=request.getParameter("insurance_name");
		String insurance_maxPrice=request.getParameter("insurance_maxPrice");
		String insurance_desc=request.getParameter("insurance_desc");
		String insurance_id=request.getParameter("insurance_id");
		Insurance insurance=new Insurance();
		insurance.setInsurance_price(insurance_price);
		insurance.setInsurance_name(insurance_name);
		insurance.setInsurance_maxPrice(insurance_maxPrice);
		insurance.setInsurance_desc(insurance_desc);
		insurance.setInsurance_id(Integer.parseInt(insurance_id));
		InsuranceService insuranceService=new InsuranceService();
		insuranceService.update(insurance);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
