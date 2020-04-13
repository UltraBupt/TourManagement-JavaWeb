package com.gs.tour.shxt.partner.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.partner.model.Partner;
import com.gs.tour.shxt.partner.service.PartnerService;

/**
 * Servlet implementation class PartnerListServlet
 */
@WebServlet("/PartnerListServlet.shxt")
public class PartnerListServlet extends HttpServlet {
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
		//查询数据
		String partner_type=request.getParameter("partner_type");
		String partner_name=request.getParameter("partner_name");
		String partner_status=request.getParameter("partner_status");
		Partner partner=new Partner();
		if(partner_type!=null&&partner_type.trim().length()>0){
			partner.setPartner_type(partner_type);
		}
		if(partner_name!=null&&partner_name.trim().length()>0){
			partner.setPartner_name(partner_name);
		}
		if(partner_status!=null&&partner_status.trim().length()>0){
			partner.setPartner_status(Integer.parseInt(partner_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		PartnerService partnerService=new PartnerService();
		request.setAttribute("pageBean", partnerService.getAllPartnerList(partner, pageBean));
		request.setAttribute("queryPartner", partner);
		request.getRequestDispatcher("WEB-INF/jsp/partner/list.jsp").forward(request, response);

	}

}
