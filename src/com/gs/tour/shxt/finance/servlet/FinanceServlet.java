package com.gs.tour.shxt.finance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.finance.model.Finance;
import com.gs.tour.shxt.finance.service.FinanceService;

/**
 * Servlet implementation class FinanceServlet
 */
@WebServlet("/FinanceServlet.shxt")
public class FinanceServlet extends HttpServlet {
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
		String finance_name=request.getParameter("finance_name");
		String finance_status=request.getParameter("finance_status");
		Finance finance=new Finance();
		if(finance_name!=null&&finance_name.trim().length()>0){
			finance.setFinance_name(finance_name);
		}
		if(finance_status!=null&&finance_status.trim().length()>0){
			finance.setFinance_status(Integer.parseInt(finance_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		FinanceService financeService=new FinanceService();
		request.setAttribute("pageBean", financeService.getAllFinanceList(finance, pageBean));
		request.setAttribute("queryFinance", finance);
		request.getRequestDispatcher("WEB-INF/jsp/finance/list.jsp").forward(request, response);
	}

}
