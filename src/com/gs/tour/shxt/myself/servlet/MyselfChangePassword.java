package com.gs.tour.shxt.myself.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.tour.shxt.user.model.User;
import com.gs.tour.shxt.user.service.UserService;
/**
 * Servlet implementation class MyselfChangePassword
 */
@WebServlet("/MyselfChangePassword.shxt")
public class MyselfChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		UserService userService=new UserService();
		request.setAttribute("user", userService.load(Integer.parseInt(user_id)));
		request.getRequestDispatcher("WEB-INF/jsp/myself/changePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("new_password");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("session_user");
		Integer user_id=user.getUser_id();
		UserService userService=new UserService();
		try {
			userService.updatePassword(user_id, password);
			request.setAttribute("flag", "success");
			request.setAttribute("message", "修改成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flag", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
