package com.gs.tour.shxt.recruit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.recruit.model.Recruit;
import com.gs.tour.shxt.recruit.service.RecruitService;

/**
 * Servlet implementation class RecruitAddServlet
 */
@WebServlet("/RecruitAddServlet.shxt")
public class RecruitAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/recruit/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recruit_company=request.getParameter("recruit_company");
		String recruit_position=request.getParameter("recruit_position");
		String recruit_salary=request.getParameter("recruit_salary");
		String recruit_address=request.getParameter("recruit_address");
		String recruit_desc=request.getParameter("recruit_desc");
		String recruit_benefit=request.getParameter("recruit_benefit");
		String recruit_date=request.getParameter("recruit_date");
		String recruit_email=request.getParameter("recruit_email");
		Recruit recruit=new Recruit();
		recruit.setRecruit_company(recruit_company);
		recruit.setRecruit_position(recruit_position);
		recruit.setRecruit_salary(recruit_salary);
		recruit.setRecruit_address(recruit_address);
		recruit.setRecruit_desc(recruit_desc);
		recruit.setRecruit_benefit(recruit_benefit);
		recruit.setRecruit_date(recruit_date);
		recruit.setRecruit_email(recruit_email);
		RecruitService recruitService=new RecruitService();
		try {
			recruitService.addRecruit(recruit);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
