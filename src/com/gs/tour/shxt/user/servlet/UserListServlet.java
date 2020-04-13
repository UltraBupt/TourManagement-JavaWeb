package com.gs.tour.shxt.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.branch.service.BranchService;
import com.gs.tour.shxt.role.service.RoleService;
import com.gs.tour.shxt.user.model.User;
import com.gs.tour.shxt.user.service.UserService;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet.shxt")
public class UserListServlet extends HttpServlet {
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
		User user=new User();
		String user_name=request.getParameter("user_name");
		String account=request.getParameter("account");
		String user_status=request.getParameter("user_status");
		if(user_name!=null&&user_name.trim().length()>0){
			user.setUser_name(user_name);
		}
		if(account!=null&&account.trim().length()>0){
			user.setAccount(account);
		}
		if(user_status!=null&&user_status.trim().length()>0){
			user.setUser_status(Integer.parseInt(user_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		UserService userService=new UserService();
		RoleService roleService=new RoleService();
		BranchService branchService=new BranchService();
		request.setAttribute("branch_list", branchService.getBranchList());
		request.setAttribute("role_list", roleService.getRoleList());
		request.setAttribute("pageBean", userService.getAllUserList(user, pageBean));
		request.setAttribute("queryUser", user);
		request.getRequestDispatcher("WEB-INF/jsp/user/list.jsp").forward(request, response);
	}

}
