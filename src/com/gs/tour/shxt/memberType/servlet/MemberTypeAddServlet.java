package com.gs.tour.shxt.memberType.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.memberType.service.MemberTypeService;

/**
 * Servlet implementation class MemberTypeAddServlet
 */
@WebServlet("/MemberTypeAddServlet.shxt")
public class MemberTypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/memberType/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberType_name=request.getParameter("memberType_name");
		String memberType_number=request.getParameter("memberType_number");
		try {
			Integer.parseInt(memberType_number);
		} catch (Exception e) {
			request.setAttribute("message", "会员升级次数只能为数字");
		}
		String memberType_desc=request.getParameter("memberType_desc");
		String memberType_benefit=request.getParameter("memberType_benefit");
		MemberTypeService memberTypeService=new MemberTypeService();
		try {
			memberTypeService.addMemberType(memberType_name, Integer.parseInt(memberType_number), memberType_desc, memberType_benefit);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
