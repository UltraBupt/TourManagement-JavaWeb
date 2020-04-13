package com.gs.tour.shxt.user.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.user.model.User;
import com.gs.tour.shxt.user.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.shxt")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		UserService userService=new UserService();
		try {
			User user=userService.login(account, password);
			//存入session
			HttpSession session=request.getSession();
			session.setAttribute("session_user", user);
			//查出登录者的信息
			String loginName=user.getUser_name();
			String loginAccount=user.getAccount();
			//获取登录时间
			Date date=new Date();
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String create_date=s.format(date);
			//将登入信息传到登入日志里
    		String sql3="insert into login_record (login_record_name,login_record_create_date,login_record_account)values('"+loginName+"','"+create_date+"','"+loginAccount+"')";
    		DBUtil.executeUpdate(sql3);
			response.sendRedirect(request.getContextPath()+"/MainServlet.shxt");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("account",account);
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
		
	}

}
