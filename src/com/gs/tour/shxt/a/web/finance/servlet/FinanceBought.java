package com.gs.tour.shxt.a.web.finance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.finance.service.WebFinanceService;

/**
 * Servlet implementation class FinanceBought
 */
@WebServlet("/FinanceBought.html")
public class FinanceBought extends HttpServlet {
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
		String finance_id=request.getParameter("finance_id");
		WebFinanceService webFinanceServcie=new WebFinanceService();
		request.setAttribute("finance", webFinanceServcie.queryFinanceByFinanceId(Integer.parseInt(finance_id)));
		request.getRequestDispatcher("WEB-INF/web/finance/financeBought.jsp").forward(request, response);
	}

}
