package com.gs.tour.shxt.salary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.salary.service.SalaryService;

/**
 * Servlet implementation class SalaryUpdateServlet
 */
@WebServlet("/SalaryUpdateServlet.shxt")
public class SalaryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salary_id=request.getParameter("salary_id");
		SalaryService salaryService=new SalaryService();
		request.setAttribute("salary", salaryService.querySalaryBySalaryId(Integer.parseInt(salary_id)));
		request.getRequestDispatcher("WEB-INF/jsp/salary/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salary_id=request.getParameter("salary_id");
		String salary_number=request.getParameter("salary_number");
		SalaryService salaryService=new SalaryService();
		try {
			salaryService.updateSalary(salary_number, Integer.parseInt(salary_id));
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
