package com.gs.tour.shxt.memberType.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.memberType.model.MemberType;
import com.gs.tour.shxt.memberType.service.MemberTypeService;

/**
 * Servlet implementation class MemberTypeListServlet
 */
@WebServlet("/MemberTypeListServlet.shxt")
public class MemberTypeListServlet extends HttpServlet {
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
		String memberType_name=request.getParameter("memberType_name");
		String memberType_benefit=request.getParameter("memberType_benefit");
		String memberType_status=request.getParameter("memberType_status");
		MemberType memberType=new MemberType();
		if(memberType_name!=null&&memberType_name.trim().length()>0){
			memberType.setMemberType_name(memberType_name);
		}
		if(memberType_benefit!=null&&memberType_benefit.trim().length()>0){
			memberType.setMemberType_benefit(memberType_benefit);
		}
		if(memberType_status!=null&&memberType_status.trim().length()>0){
			memberType.setMemberType_status(Integer.parseInt(memberType_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		MemberTypeService memberTypeService=new MemberTypeService();
		request.setAttribute("pageBean", memberTypeService.getAllMemberTypeList(memberType, pageBean));
		request.setAttribute("queryMemberType", memberType);
		request.getRequestDispatcher("WEB-INF/jsp/memberType/list.jsp").forward(request, response);
	}
}
