package com.gs.tour.shxt.a.web.quick.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.quick.service.WebQuickService;

/**
 * Servlet implementation class QuickBought
 */
@WebServlet("/QuickBought.html")
public class QuickBought extends HttpServlet {
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
		String quick_id=request.getParameter("quick_id");
		WebQuickService webQuickServcie=new WebQuickService();
		request.setAttribute("quick", webQuickServcie.queryQuickByQuickId(Integer.parseInt(quick_id)));
		request.getRequestDispatcher("WEB-INF/web/quick/quickBought.jsp").forward(request, response);
	}

}
