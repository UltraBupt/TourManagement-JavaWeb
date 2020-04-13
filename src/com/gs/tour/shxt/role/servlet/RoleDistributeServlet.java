package com.gs.tour.shxt.role.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.menu.service.MenuService;
import com.gs.tour.shxt.role.service.RoleService;

/**
 * Servlet implementation class RoleDistributeServlet
 */
@WebServlet("/RoleDistributeServlet.shxt")
public class RoleDistributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_id=request.getParameter("role_id");
		MenuService menuService=new MenuService();
		//当前角色具有的全部子菜单
		request.setAttribute("selectedMenuList", menuService.getSelectMenuListByRoleId(Integer.parseInt(role_id)));
		//当前角色不具有的全部子菜单
		request.setAttribute("unSelectedMenuList", menuService.getUnSelectedMenuListByRoleId(Integer.parseInt(role_id)));
		request.setAttribute("role_id", role_id);
		request.getRequestDispatcher("WEB-INF/jsp/role/distribute.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_id=request.getParameter("role_id");
		String [] menus=request.getParameterValues("menus");
		RoleService roleService=new RoleService();
		try {
			roleService.distributeMenuByRoleId(Integer.parseInt(role_id), menus);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "分配成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
