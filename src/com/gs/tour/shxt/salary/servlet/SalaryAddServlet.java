package com.gs.tour.shxt.salary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.role.service.RoleService;
import com.gs.tour.shxt.salary.service.SalaryService;

/**
 * Servlet implementation class SalaryAddServlet
 */
@WebServlet("/SalaryAddServlet.shxt")
public class SalaryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService=new RoleService();
		request.setAttribute("role_list", roleService.getRoleList());
		request.getRequestDispatcher("WEB-INF/jsp/salary/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fk_role_id=request.getParameter("fk_role_id");
		String salary_number=request.getParameter("salary_number");
		SalaryService salaryService=new SalaryService();
		try {
			salaryService.addSalary(Integer.parseInt(fk_role_id), salary_number);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
