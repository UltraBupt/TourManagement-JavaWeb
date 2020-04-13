package com.gs.tour.shxt.partner.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.partner.model.Partner;
import com.gs.tour.shxt.partner.service.PartnerService;
import com.gs.tour.shxt.partnerType.service.PartnerTypeService;

/**
 * Servlet implementation class PartnerUpdateServlet
 */
@WebServlet("/PartnerUpdateServlet.shxt")
public class PartnerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partner_id=request.getParameter("partner_id");
		PartnerService partnerService=new PartnerService();
		PartnerTypeService partnerTypeService=new PartnerTypeService();
		request.setAttribute("partner", partnerService.load(Integer.parseInt(partner_id)));
		request.setAttribute("partnerType_list", partnerTypeService.getAllPartnerType());
		request.getRequestDispatcher("WEB-INF/jsp/partner/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partner_name=request.getParameter("partner_name");
		String partner_position=request.getParameter("partner_position");
		String partner_hobby=request.getParameter("partner_hobby");
		String partner_desc=request.getParameter("partner_desc");
		String fk_partnerType_id=request.getParameter("fk_partnerType_id");
		String partner_id=request.getParameter("partner_id");
		Partner partner=new Partner();
		partner.setPartner_name(partner_name);
		partner.setPartner_position(partner_position);
		partner.setPartner_hobby(partner_hobby);
		partner.setPartner_desc(partner_desc);
		partner.setFk_partnerType_id(Integer.parseInt(fk_partnerType_id));
		partner.setPartner_id(Integer.parseInt(partner_id));
		PartnerService partnerService=new PartnerService();
		partnerService.update(partner);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功");
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
