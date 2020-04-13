package com.gs.tour.shxt.a.web.agricola.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.agricola.service.WebAgricolaService;

/**
 * Servlet implementation class AgricolaBought
 */
@WebServlet("/AgricolaBought.html")
public class AgricolaBought extends HttpServlet {
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
		String agricola_id=request.getParameter("agricola_id");
		WebAgricolaService webAgricolaServcie=new WebAgricolaService();
		request.setAttribute("agricola", webAgricolaServcie.queryAgricolaByAgricolaId(Integer.parseInt(agricola_id)));
		request.getRequestDispatcher("WEB-INF/web/agricola/agricolaBought.jsp").forward(request, response);
	}

}
