package com.gs.tour.shxt.myself.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.branch.service.BranchService;
import com.gs.tour.shxt.user.model.User;
import com.gs.tour.shxt.user.service.UserService;

/**
 * Servlet implementation class MyselfUpdateInformation
 */
@WebServlet("/MyselfUpdateInformation.shxt")
public class MyselfUpdateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		UserService userService=new UserService();
		BranchService branchService=new BranchService();
		request.setAttribute("branch_list", branchService.getBranchList());
		request.setAttribute("user", userService.load(Integer.parseInt(user_id)));
		request.getRequestDispatcher("WEB-INF/jsp/myself/updateInformation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		String fk_org_id=request.getParameter("fk_org_id");
		String user_name=request.getParameter("user_name");
		String user_code=request.getParameter("user_code");
		String user_tel=request.getParameter("user_tel");
		String user_sex=request.getParameter("user_sex");
		String user_email=request.getParameter("user_email");
		User user=new User();
		user.setUser_id(Integer.parseInt(user_id));
		user.setFk_org_id(Integer.parseInt(fk_org_id));
		user.setUser_name(user_name);
		user.setUser_code(user_code);
		user.setUser_tel(user_tel);
		user.setUser_sex(user_sex);
		user.setUser_email(user_email);
		UserService userService=new UserService();
		try {
			userService.updateMyselfInformation(user);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "编辑成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
