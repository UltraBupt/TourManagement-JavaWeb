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
 * Servlet implementation class VisaUpdateServlet
 */
@WebServlet("/VisaUpdateServlet.shxt")
public class VisaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String visa_id=request.getParameter("visa_id");
		VisaService visaService=new VisaService();
		request.setAttribute("visa",visaService.load(Integer.parseInt(visa_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/visa/update.jsp").forward(request, response);
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
		String visa_id=request.getParameter("visa_id");
		Visa visa=new Visa();
		visa.setVisa_address(visa_address);
		visa.setVisa_date(visa_date);
		visa.setVisa_price(visa_price);
		visa.setVisa_number(visa_number);
		visa.setVisa_day(visa_day);
		System.out.println(visa_day);
		visa.setVisa_useful(visa_useful);
		visa.setVisa_id(Integer.parseInt(visa_id));
		VisaService visaService=new VisaService();
		visaService.update(visa);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
