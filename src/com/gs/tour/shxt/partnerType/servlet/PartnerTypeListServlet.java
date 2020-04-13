package com.gs.tour.shxt.partnerType.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.partnerType.model.PartnerType;
import com.gs.tour.shxt.partnerType.service.PartnerTypeService;

/**
 * Servlet implementation class PartnerTypeListServlet
 */
@WebServlet("/PartnerTypeListServlet.shxt")
public class PartnerTypeListServlet extends HttpServlet {
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
		String partnerType_name=request.getParameter("partnerType_name");
		String partnerType_status=request.getParameter("partnerType_status");
		PartnerType partnerType=new PartnerType();
		if(partnerType_name!=null&&partnerType_name.trim().length()>0){
			partnerType.setPartnerType_name(partnerType_name);
		}
		if(partnerType_status!=null&&partnerType_status.trim().length()>0){
			partnerType.setPartnerType_status(Integer.parseInt(partnerType_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		PartnerTypeService partnerTypeService=new PartnerTypeService();
		request.setAttribute("pageBean", partnerTypeService.getAllPartnerTypeList(partnerType, pageBean));
		request.setAttribute("queryPartnerType", partnerType);
		request.getRequestDispatcher("WEB-INF/jsp/partnerType/list.jsp").forward(request, response);
	}
}
