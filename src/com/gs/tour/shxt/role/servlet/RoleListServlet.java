package com.gs.tour.shxt.role.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.role.model.Role;
import com.gs.tour.shxt.role.service.RoleService;

/**
 * Servlet implementation class RoleListServlet
 */
@WebServlet("/RoleListServlet.shxt")
public class RoleListServlet extends HttpServlet {
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
		String role_name=request.getParameter("role_name");
		String role_status=request.getParameter("role_status");
		Role role=new Role();
		if(role_name!=null&&role_name.trim().length()>0){
			role.setRole_name(role_name);
		}
		if(role_status!=null&&role_status.trim().length()>0){
			role.setRole_status(Integer.parseInt(role_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		RoleService roleService=new RoleService();
		request.setAttribute("pageBean", roleService.getAllRoleList(role, pageBean));
		request.setAttribute("queryRole", role);
		request.getRequestDispatcher("WEB-INF/jsp/role/list.jsp").forward(request, response);
	}
}
