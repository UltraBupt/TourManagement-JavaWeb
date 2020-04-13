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
 * Servlet implementation class WebLoginServlet
 */
@WebServlet("/WebLoginServlet.html")
public class WebLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/web/login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		WebMemberService webMemberService=new WebMemberService();
		try {
			Member member=webMemberService.login(account, password);
			HttpSession session=request.getSession();
			session.setAttribute("session_member", member);
			request.setAttribute("message", "登录成功");
			request.getRequestDispatcher("WEB-INF/web/login/login.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("account",account);
			request.getRequestDispatcher("WEB-INF/web/login/login.jsp").forward(request, response);
		}
	}
}
