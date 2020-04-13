package com.gs.tour.shxt.login_record.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.login_record.model.LoginRecord;
import com.gs.tour.shxt.login_record.service.LoginRecordService;

/**
 * Servlet implementation class LoginListServlet
 */
@WebServlet("/LoginListServlet.shxt")
public class LoginListServlet extends HttpServlet {
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
		String login_record_name=request.getParameter("login_record_name");
		String login_record_account=request.getParameter("login_record_account");
		LoginRecord loginRecord=new LoginRecord();
		if(login_record_name!=null&&login_record_name.trim().length()>0){
			loginRecord.setLogin_record_name(login_record_name);
		}
		if(login_record_account!=null&&login_record_account.trim().length()>0){
			loginRecord.setLogin_record_account(login_record_account);
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		LoginRecordService loginRecordService=new LoginRecordService();
		request.setAttribute("pageBean", loginRecordService.getAllLoginRecoerdList(loginRecord, pageBean));
		request.setAttribute("queryLoginRecord", loginRecord);
		request.getRequestDispatcher("WEB-INF/jsp/login_record/list.jsp").forward(request, response);
	}
}
