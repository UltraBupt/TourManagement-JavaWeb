package com.gs.tour.shxt.partnerType.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.partnerType.model.PartnerType;
import com.gs.tour.shxt.partnerType.service.PartnerTypeService;

/**
 * Servlet implementation class PartnerTypeUpdateServlet
 */
@WebServlet("/PartnerTypeUpdateServlet.shxt")
public class PartnerTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partnerType_id=request.getParameter("partnerType_id");
		PartnerTypeService partnerTypeService=new PartnerTypeService();
		request.setAttribute("partnerType", partnerTypeService.load(Integer.parseInt(partnerType_id)));
		request.getRequestDispatcher("WEB-INF/jsp/partnerType/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partnerType_name=request.getParameter("partnerType_name");
		String partnerType_desc=request.getParameter("partnerType_desc");
		String partnerType_id=request.getParameter("partnerType_id");
		PartnerType partnerType=new PartnerType();
		partnerType.setPartnerType_name(partnerType_name);
		partnerType.setPartnerType_desc(partnerType_desc);
		partnerType.setPartnerType_id(Integer.parseInt(partnerType_id));
		PartnerTypeService partnerTypeService=new PartnerTypeService();
		partnerTypeService.update(partnerType);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
