package com.gs.tour.shxt.memberType.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.memberType.model.MemberType;
import com.gs.tour.shxt.memberType.service.MemberTypeService;

/**
 * Servlet implementation class MemberTypeUpdateServlet
 */
@WebServlet("/MemberTypeUpdateServlet.shxt")
public class MemberTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberType_id=request.getParameter("memberType_id");
		MemberTypeService memberTypeService=new MemberTypeService();
		request.setAttribute("memberType", memberTypeService.load(Integer.parseInt(memberType_id)));
		request.getRequestDispatcher("WEB-INF/jsp/memberType/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberType_name=request.getParameter("memberType_name");
		String memberType_number=request.getParameter("memberType_number");
		String memberType_desc=request.getParameter("memberType_desc");
		String memberType_benefit=request.getParameter("memberType_benefit");
		String memberType_id=request.getParameter("memberType_id");
		MemberType memberType=new MemberType();
		memberType.setMemberType_name(memberType_name);
		memberType.setMemberType_number(Integer.parseInt(memberType_number));
		memberType.setMemberType_desc(memberType_desc);
		memberType.setMemberType_benefit(memberType_benefit);
		memberType.setMemberType_id(Integer.parseInt(memberType_id));
		MemberTypeService memberTypeService=new MemberTypeService();
		memberTypeService.update(memberType);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
