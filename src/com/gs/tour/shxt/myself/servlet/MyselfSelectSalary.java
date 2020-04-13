package com.gs.tour.shxt.myself.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.salary.service.SalaryService;

/**
 * Servlet implementation class MyselfSelectSalary
 */
@WebServlet("/MyselfSelectSalary.shxt")
public class MyselfSelectSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		SalaryService salaryService=new SalaryService();
		request.setAttribute("salary_number", salaryService.querySalaryByUserId(Integer.parseInt(user_id)).getSalary_number());
		request.getRequestDispatcher("WEB-INF/jsp/myself/selectSalary.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
