package com.gs.tour.shxt.role.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.role.service.RoleService;

/**
 * Servlet implementation class RoleAddServlet
 */
@WebServlet("/RoleAddServlet.shxt")
public class RoleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/role/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_name=request.getParameter("role_name");
		String role_desc=request.getParameter("role_desc");
		RoleService roleService=new RoleService();
		try {
			roleService.addRole(role_name, role_desc);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			request.setAttribute("flg", "erroe");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
