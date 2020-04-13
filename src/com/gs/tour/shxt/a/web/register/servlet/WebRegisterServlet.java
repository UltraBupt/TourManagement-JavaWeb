package com.gs.tour.shxt.a.web.register.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.register.model.Member;
import com.gs.tour.shxt.a.web.register.service.WebRegisterService;

/**
 * Servlet implementation class WebRegisterServlet
 */
@WebServlet("/WebRegisterServlet.html")
public class WebRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/web/register/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_name=request.getParameter("member_name");
		String member_account=request.getParameter("member_account");
		String member_password=request.getParameter("password");
		Member member=new Member();
		member.setMember_name(member_name);
		member.setMember_account(member_account);
		member.setMember_password(member_password);
		WebRegisterService webRegisterService=new WebRegisterService();
		try {
			webRegisterService.addMember(member);
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("WEB-INF/web/register/register.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("WEB-INF/web/register/register.jsp").forward(request, response);
		}
	}

}
