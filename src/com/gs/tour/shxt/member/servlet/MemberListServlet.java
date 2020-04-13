package com.gs.tour.shxt.member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.member.model.Member;
import com.gs.tour.shxt.member.service.MemberService;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/MemberListServlet.shxt")
public class MemberListServlet extends HttpServlet {
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
		String member_type=request.getParameter("member_type");
		String member_account=request.getParameter("member_account");
		String member_status=request.getParameter("member_status");
		Member member=new Member();
		if(member_type!=null&&member_type.trim().length()>0){
			member.setMember_type(member_type);
		}
		if(member_account!=null&&member_account.trim().length()>0){
			member.setMember_account(member_account);
		}
		if(member_status!=null&&member_status.trim().length()>0){
			member.setMember_status(Integer.parseInt(member_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		MemberService memberService=new MemberService();
		request.setAttribute("pageBean", memberService.getAllMemberList(member, pageBean));
		request.setAttribute("queryMember", member);
		request.getRequestDispatcher("WEB-INF/jsp/member/list.jsp").forward(request, response);
	}
}
