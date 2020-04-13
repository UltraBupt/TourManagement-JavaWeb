package com.gs.tour.shxt.a.web.bill.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.tour.shxt.a.web.bill.model.Bill;
import com.gs.tour.shxt.a.web.bill.service.BillService;
import com.gs.tour.shxt.a.web.login.model.Member;

/**
 * Servlet implementation class WebBillListServlet15
 */
@WebServlet("/WebBillListServlet15.html")
public class WebBillListServlet15 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bill_thing=request.getParameter("bill_thing");
		String bill_memberPhone=request.getParameter("bill_memberPhone");
		String bill_price=request.getParameter("bill_price");
		String bill_number=request.getParameter("bill_number");
		String bill_type="快捷酒店";
		String bill_code=UUID.randomUUID().toString();
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("session_member");
		Bill bill=new Bill();
		bill.setBill_thing(bill_thing);
		bill.setBill_memberPhone(bill_memberPhone);
		bill.setBill_price(bill_price);
		bill.setBill_number(bill_number);
		bill.setBill_type(bill_type);
		bill.setBill_code(bill_code);
		BillService billService=new BillService();
		billService.createBill(bill, member);
		request.getRequestDispatcher("WEB-INF/web/index/index.jsp").forward(request, response);
	}

}
