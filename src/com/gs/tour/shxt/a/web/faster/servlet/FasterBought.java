package com.gs.tour.shxt.a.web.faster.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.faster.service.WebFasterService;

/**
 * Servlet implementation class FasterBought
 */
@WebServlet("/FasterBought.html")
public class FasterBought extends HttpServlet {
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
		String faster_id=request.getParameter("faster_id");
		WebFasterService webFasterServcie=new WebFasterService();
		request.setAttribute("faster", webFasterServcie.queryFasterByFasterId(Integer.parseInt(faster_id)));
		request.getRequestDispatcher("WEB-INF/web/faster/fasterBought.jsp").forward(request, response);
	}

}
