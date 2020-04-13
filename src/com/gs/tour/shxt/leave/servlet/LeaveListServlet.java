package com.gs.tour.shxt.leave.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.leave.model.Leave;
import com.gs.tour.shxt.leave.service.LeaveService;

/**
 * Servlet implementation class LeaveListServlet
 */
@WebServlet("/LeaveListServlet.shxt")
public class LeaveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询数据
		String leave_name=request.getParameter("leave_name");
		String leave_day=request.getParameter("leave_day");
		String leave_status=request.getParameter("leave_status");
		Leave leave=new Leave();
		if(leave_name!=null&&leave_name.trim().length()>0){
			leave.setLeave_name(leave_name);
		}
		if(leave_day!=null&&leave_day.trim().length()>0){
			leave.setLeave_day(leave_day);
		}
		if(leave_status!=null&&leave_status.trim().length()>0){
			leave.setLeave_status(Integer.parseInt(leave_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		LeaveService leaveService=new LeaveService();
		request.setAttribute("pageBean", leaveService.getAllLeaveList(leave, pageBean));
		request.setAttribute("queryLeave", leave);
		request.getRequestDispatcher("WEB-INF/jsp/leave/list.jsp").forward(request, response);
	}
}
