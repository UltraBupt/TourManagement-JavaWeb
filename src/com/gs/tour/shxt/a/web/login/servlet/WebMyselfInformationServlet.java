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
 * Servlet implementation class WebMyselfInformationServlet
 */
@WebServlet("/WebMyselfInformationServlet.html")
public class WebMyselfInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member member=(Member) session.getAttribute("session_member");
		if(member!=null){
			Integer member_id=member.getMember_id();
			WebMemberService webMemberService=new WebMemberService();
			request.setAttribute("member", webMemberService.load(member_id));
		}
		request.getRequestDispatcher("WEB-INF/web/login/information.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
