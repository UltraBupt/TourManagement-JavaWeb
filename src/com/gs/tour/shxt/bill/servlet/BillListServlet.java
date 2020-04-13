package com.gs.tour.shxt.bill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.bill.model.Bill;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.bill.service.BillService;

/**
 * Servlet implementation class BillListServlet
 */
@WebServlet("/BillListServlet.shxt")
public class BillListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		//查询数据
		String bill_type=request.getParameter("bill_type");
		String bill_status=request.getParameter("bill_status");
		Bill bill=new Bill();
		if(bill_type!=null&&bill_type.trim().length()>0){
			bill.setBill_type(bill_type);
		}
		if(bill_status!=null&&bill_status.trim().length()>0){
			bill.setBill_status(Integer.parseInt(bill_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		BillService billService=new BillService();
		request.setAttribute("pageBean", billService.getAllBillList(bill, pageBean));
		request.setAttribute("queryBill", bill);
		request.getRequestDispatcher("WEB-INF/jsp/bill/list.jsp").forward(request, response);
	}

}
