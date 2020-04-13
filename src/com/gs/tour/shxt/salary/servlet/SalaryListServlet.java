package com.gs.tour.shxt.salary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.salary.model.Salary;
import com.gs.tour.shxt.salary.service.SalaryService;

/**
 * Servlet implementation class SalaryListServlet
 */
@WebServlet("/SalaryListServlet.shxt")
public class SalaryListServlet extends HttpServlet {
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
		String salary_number=request.getParameter("salary_number");
		String position_name=request.getParameter("position_name");
		Salary salary=new Salary();
		if(salary_number!=null&&salary_number.trim().length()>0){
			salary.setSalary_number(salary_number);
		}
		if(position_name!=null&&position_name.trim().length()>0){
			salary.setPosition_name(position_name);
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		SalaryService salaryService=new SalaryService();
		request.setAttribute("pageBean", salaryService.getAllSalaryList(salary, pageBean));
		request.setAttribute("querySalary", salary);
		request.getRequestDispatcher("WEB-INF/jsp/salary/list.jsp").forward(request, response);
	}

}
