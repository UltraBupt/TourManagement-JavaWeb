package com.gs.tour.shxt.main.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.tour.shxt.menu.service.MenuService;
import com.gs.tour.shxt.user.model.User;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet.shxt")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("session_user");
		Integer role_id=user.getFk_role_id();
		MenuService menuService=new MenuService();
		//父节点
		request.setAttribute("parentList", menuService.getParentMenuListByRoleId(role_id));
		//子节点
		request.setAttribute("childList", menuService.getChildMenuListByRoleId(role_id));
		//跳转到主界面
		request.getRequestDispatcher("WEB-INF/jsp/main/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
