package com.gs.tour.shxt.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.user.model.User;
import com.gs.tour.shxt.user.service.UserService;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet.shxt")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		UserService userService=new UserService();
		request.setAttribute("user",userService.load(Integer.parseInt(user_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/user/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name=request.getParameter("user_name");
		String user_status=request.getParameter("user_status");
		String user_id=request.getParameter("user_id");
		User user=new User();
		user.setUser_name(user_name);
		user.setUser_status(Integer.parseInt(user_status));
		user.setUser_id(Integer.parseInt(user_id));
		UserService userService=new UserService();
		userService.update(user);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
