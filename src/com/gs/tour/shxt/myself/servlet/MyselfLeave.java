package com.gs.tour.shxt.myself.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.tour.shxt.leave.model.Leave;
import com.gs.tour.shxt.leave.service.LeaveService;
import com.gs.tour.shxt.user.model.User;

/**
 * Servlet implementation class MyselfLeave
 */
@WebServlet("/MyselfLeave.shxt")
public class MyselfLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/myself/leave.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Leave leave=new Leave();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("session_user");
		leave.setLeave_day(request.getParameter("leave_day"));
		leave.setLeave_desc(request.getParameter("leave_desc"));
		leave.setLeave_startDay(request.getParameter("leave_startDay"));
		leave.setLeave_overDay(request.getParameter("leave_overDay"));
		LeaveService leaveService=new LeaveService();
		try {
			leaveService.addLeave(leave, user);
			request.setAttribute("flag", "success");
			request.setAttribute("message", "创建成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flag", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
