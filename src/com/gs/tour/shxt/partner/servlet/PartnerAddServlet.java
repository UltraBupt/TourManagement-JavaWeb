package com.gs.tour.shxt.partner.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.partner.service.PartnerService;
import com.gs.tour.shxt.partnerType.service.PartnerTypeService;

/**
 * Servlet implementation class PartnerAddServlet
 */
@WebServlet("/PartnerAddServlet.shxt")
public class PartnerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartnerTypeService partnerTypeService=new PartnerTypeService();
		request.setAttribute("partnerType_list", partnerTypeService.getAllPartnerType());
		request.getRequestDispatcher("WEB-INF/jsp/partner/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fk_partnerType_id=request.getParameter("fk_partnerType_id");
		String partner_name=request.getParameter("partner_name");
		String partner_position=request.getParameter("partner_position");
		String partner_hobby=request.getParameter("partner_hobby");
		String partner_desc=request.getParameter("partner_desc");
		PartnerService partnerService=new PartnerService();
		try {
			partnerService.addPartner(Integer.parseInt(fk_partnerType_id), partner_name, partner_position, partner_hobby, partner_desc);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
