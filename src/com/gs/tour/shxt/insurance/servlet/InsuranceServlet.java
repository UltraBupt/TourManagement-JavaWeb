package com.gs.tour.shxt.insurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.insurance.model.Insurance;
import com.gs.tour.shxt.insurance.service.InsuranceService;

/**
 * Servlet implementation class InsuranceServlet
 */
@WebServlet("/InsuranceServlet.shxt")
public class InsuranceServlet extends HttpServlet {
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
		String insurance_name=request.getParameter("insurance_name");
		String insurance_status=request.getParameter("insurance_status");
		Insurance insurance=new Insurance();
		if(insurance_name!=null&&insurance_name.trim().length()>0){
			insurance.setInsurance_name(insurance_name);
		}
		if(insurance_status!=null&&insurance_status.trim().length()>0){
			insurance.setInsurance_status(Integer.parseInt(insurance_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		InsuranceService insuranceService=new InsuranceService();
		request.setAttribute("pageBean", insuranceService.getAllInsuranceList(insurance, pageBean));
		request.setAttribute("queryInsurance", insurance);
		request.getRequestDispatcher("WEB-INF/jsp/insurance/list.jsp").forward(request, response);
	}
}
