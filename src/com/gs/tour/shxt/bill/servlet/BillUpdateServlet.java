package com.gs.tour.shxt.bill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.bill.model.Bill;
import com.gs.tour.shxt.bill.service.BillService;

/**
 * Servlet implementation class BillUpdateServlet
 */
@WebServlet("/BillUpdateServlet.shxt")
public class BillUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bill_id=request.getParameter("bill_id");
		BillService billService=new BillService();
		request.setAttribute("bill",billService.load(Integer.parseInt(bill_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/bill/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bill_status=request.getParameter("bill_status");
		String bill_id=request.getParameter("bill_id");
		Bill bill=new Bill();
		bill.setBill_status(Integer.parseInt(bill_status));
		bill.setBill_id(Integer.parseInt(bill_id));
		BillService billService=new BillService();
		billService.update(bill);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
