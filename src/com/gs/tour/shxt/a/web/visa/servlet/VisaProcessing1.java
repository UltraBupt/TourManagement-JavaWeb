package com.gs.tour.shxt.a.web.visa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.visa.service.WebVisaService;

/**
 * Servlet implementation class VisaProcessing
 */
@WebServlet(name = "VisaProcessing1", urlPatterns = { "/VisaProcessing1.html" })
public class VisaProcessing1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebVisaService webVisaService=new WebVisaService();
		request.setAttribute("visa", webVisaService.getVisaList());
		request.getRequestDispatcher("WEB-INF/web/visa/visa.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
