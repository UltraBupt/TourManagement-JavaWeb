package com.gs.tour.shxt.visa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.visa.model.Visa;
import com.gs.tour.shxt.visa.service.VisaService;

/**
 * Servlet implementation class VisaProcessing
 */
@WebServlet("/VisaProcessing.shxt")
public class VisaProcessing extends HttpServlet {
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
		String visa_address=request.getParameter("visa_address");
		String visa_status=request.getParameter("visa_status");
		Visa visa=new Visa();
		if(visa_address!=null&&visa_address.trim().length()>0){
			visa.setVisa_address(visa_address);
		}
		if(visa_status!=null&&visa_status.trim().length()>0){
			visa.setVisa_status(Integer.parseInt(visa_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		VisaService visaService=new VisaService();
		request.setAttribute("pageBean", visaService.getAllVisaList(visa, pageBean));
		request.setAttribute("queryVisa", visa);
		request.getRequestDispatcher("WEB-INF/jsp/visa/list.jsp").forward(request, response);
	}

}
