package com.gs.tour.shxt.a.web.visa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.visa.service.WebVisaService;

/**
 * Servlet implementation class VisaBought
 */
@WebServlet("/VisaBought.html")
public class VisaBought extends HttpServlet {
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
		String visa_id=request.getParameter("visa_id");
		WebVisaService webVisaServcie=new WebVisaService();
		request.setAttribute("visa", webVisaServcie.queryVisaByVisaId(Integer.parseInt(visa_id)));
		request.getRequestDispatcher("WEB-INF/web/visa/visaBought.jsp").forward(request, response);
	}

}
