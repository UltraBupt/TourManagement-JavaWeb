package com.gs.tour.shxt.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.role.service.RoleService;
import com.gs.tour.shxt.user.service.UserService;

/**
 * Servlet implementation class UserDistributeServlet
 */
@WebServlet("/UserDistributeServlet.shxt")
public class UserDistributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService=new RoleService();
		UserService userService=new UserService();
		request.setAttribute("user",userService.queryUserByUserId(Integer.parseInt(request.getParameter("user_id"))));
		request.setAttribute("role_list", roleService.getRoleList());
		request.getRequestDispatcher("WEB-INF/jsp/user/distribute.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		String fk_role_id=request.getParameter("fk_role_id");
		UserService userService=new UserService();
		try {
			userService.updateUserRoleByUserId(Integer.parseInt(fk_role_id), Integer.parseInt(user_id));
			request.setAttribute("flg", "success");
			request.setAttribute("message", "分配成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
