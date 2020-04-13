package com.gs.tour.shxt.visa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.visa.model.Visa;
import com.gs.tour.shxt.visa.service.VisaService;

/**
 * Servlet implementation class VisaAddServlet
 */
@WebServlet("/VisaAddServlet.shxt")
public class VisaAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/visa/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String visa_address=request.getParameter("visa_address");
		String visa_date=request.getParameter("visa_date");
		String visa_price=request.getParameter("visa_price");
		String visa_number=request.getParameter("visa_number");
		String visa_day=request.getParameter("visa_day");
		String visa_useful=request.getParameter("visa_useful");
		Visa visa=new Visa();
		visa.setVisa_address(visa_address);
		visa.setVisa_date(visa_date);
		visa.setVisa_price(visa_price);
		visa.setVisa_number(visa_number);
		visa.setVisa_day(visa_day);
		visa.setVisa_useful(visa_useful);
		VisaService visaService=new VisaService();
		try {
			visaService.addVisa(visa);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
