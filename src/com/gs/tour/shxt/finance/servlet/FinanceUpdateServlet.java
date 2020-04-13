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
 * Servlet implementation class FinanceUpdateServlet
 */
@WebServlet("/FinanceUpdateServlet.shxt")
public class FinanceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String finance_id=request.getParameter("finance_id");
		FinanceService financeService=new FinanceService();
		request.setAttribute("finance",financeService.load(Integer.parseInt(finance_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/finance/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String finance_name=request.getParameter("finance_name");
		String finance_price=request.getParameter("finance_price");
		String finance_number=request.getParameter("finance_number");
		String finance_desc=request.getParameter("finance_desc");
		String finance_id=request.getParameter("finance_id");
		Finance finance=new Finance();
		finance.setFinance_name(finance_name);
		finance.setFinance_price(finance_price);
		finance.setFinance_number(finance_number);
		finance.setFinance_desc(finance_desc);
		finance.setFinance_id(Integer.parseInt(finance_id));
		FinanceService financeService=new FinanceService();
		financeService.update(finance);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
