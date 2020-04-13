package com.gs.tour.shxt.a.web.login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.tour.shxt.a.web.login.model.Member;
import com.gs.tour.shxt.a.web.login.service.WebMemberService;

/**
 * Servlet implementation class WebChangePasswordServlet
 */
@WebServlet("/WebChangePasswordServlet.html")
public class WebChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/web/login/changePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("new_password");
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("session_member");
		Integer member_id=member.getMember_id();
		WebMemberService webMemberService=new WebMemberService();
		try {
			webMemberService.updatePassword(member_id, password);
			request.setAttribute("flag", "success");
			request.setAttribute("message", "修改成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flag", "error");
		}
		request.getRequestDispatcher("/WEB-INF/web/login/changePassword.jsp").forward(request, response);
	}

}
