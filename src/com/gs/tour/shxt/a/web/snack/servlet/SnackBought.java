package com.gs.tour.shxt.a.web.snack.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.snack.service.WebSnackService;

/**
 * Servlet implementation class SnackBought
 */
@WebServlet("/SnackBought.html")
public class SnackBought extends HttpServlet {
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
		String snack_id=request.getParameter("snack_id");
		WebSnackService webSnackServcie=new WebSnackService();
		request.setAttribute("snack", webSnackServcie.querySnackBySnackId(Integer.parseInt(snack_id)));
		request.getRequestDispatcher("WEB-INF/web/snack/snackBought.jsp").forward(request, response);
	}

}
