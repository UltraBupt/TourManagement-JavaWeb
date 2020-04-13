package com.gs.tour.shxt.recruit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.recruit.model.Recruit;
import com.gs.tour.shxt.recruit.service.RecruitService;

/**
 * Servlet implementation class RecruitListServlet
 */
@WebServlet("/RecruitListServlet.shxt")
public class RecruitListServlet extends HttpServlet {
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
		String recruit_company=request.getParameter("recruit_company");
		String recruit_status=request.getParameter("recruit_status");
		Recruit recruit=new Recruit();
		if(recruit_company!=null&&recruit_company.trim().length()>0){
			recruit.setRecruit_company(recruit_company);
		}
		if(recruit_status!=null&&recruit_status.trim().length()>0){
			recruit.setRecruit_status(Integer.parseInt(recruit_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		RecruitService recruitService=new RecruitService();
		request.setAttribute("pageBean", recruitService.getAllRecruitList(recruit, pageBean));
		request.setAttribute("queryRecruit", recruit);
		request.getRequestDispatcher("WEB-INF/jsp/recruit/list.jsp").forward(request, response);
	}
}
