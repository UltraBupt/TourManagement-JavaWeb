package com.gs.tour.shxt.finance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.finance.model.Finance;
import com.gs.tour.shxt.finance.service.FinanceService;

/**
 * Servlet implementation class FinanceAddServlet
 */
@WebServlet("/FinanceAddServlet.shxt")
public class FinanceAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/finance/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String finance_name=request.getParameter("finance_name");
		String finance_price=request.getParameter("finance_price");
		String finance_number=request.getParameter("finance_number");
		String finance_desc=request.getParameter("finance_desc");
		Finance finance=new Finance();
		finance.setFinance_name(finance_name);
		finance.setFinance_price(finance_price);
		finance.setFinance_number(finance_number);
		finance.setFinance_desc(finance_desc);
		FinanceService financeService=new FinanceService();
		try {
			financeService.addFinance(finance);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
