package com.gs.tour.shxt.leave.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.leave.model.Leave;
import com.gs.tour.shxt.leave.service.LeaveService;

/**
 * Servlet implementation class OperatorLeaveServlet
 */
@WebServlet("/OperatorLeaveServlet.shxt")
public class OperatorLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leave_id=request.getParameter("leave_id");
		LeaveService leaveService=new LeaveService();
		request.setAttribute("leave", leaveService.load(Integer.parseInt(leave_id)));
		request.getRequestDispatcher("WEB-INF/jsp/leave/operator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leave_status=request.getParameter("leave_status");
		String leave_id=request.getParameter("leave_id");
		Leave leave=new Leave();
		leave.setLeave_status(Integer.parseInt(leave_status));
		leave.setLeave_id(Integer.parseInt(leave_id));
		LeaveService leaveService=new LeaveService();
		leaveService.operator(leave);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
