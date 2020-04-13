package com.gs.tour.shxt.a.web.message.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.tour.shxt.a.web.login.model.Member;
import com.gs.tour.shxt.a.web.message.service.WebMessageService;

/**
 * Servlet implementation class NewMessage
 */
@WebServlet("/NewMessage.html")
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/web/message/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newMessage=request.getParameter("newMessage");
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("session_member");
		WebMessageService webMessageService=new WebMessageService();
		request.setAttribute("message","添加成功");
		request.getRequestDispatcher("WEB-INF/web/message/message.jsp").forward(request, response);
		try {
			webMessageService.addMessage(member, newMessage);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("WEB-INF/web/message/message.jsp").forward(request, response);
		}
	}

}
