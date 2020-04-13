package com.gs.tour.shxt.a.web.themed.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.themed.service.WebThemedService;

/**
 * Servlet implementation class ThemedBought
 */
@WebServlet("/ThemedBought.html")
public class ThemedBought extends HttpServlet {
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
		String themed_id=request.getParameter("themed_id");
		WebThemedService webThemedServcie=new WebThemedService();
		request.setAttribute("themed", webThemedServcie.queryThemedByThemedId(Integer.parseInt(themed_id)));
		request.getRequestDispatcher("WEB-INF/web/themed/themedBought.jsp").forward(request, response);
	}

}
