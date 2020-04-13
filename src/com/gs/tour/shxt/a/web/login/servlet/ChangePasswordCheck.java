package com.gs.tour.shxt.a.web.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.gs.tour.shxt.a.web.login.model.Member;
import com.gs.tour.shxt.a.web.login.service.WebMemberService;

/**
 * Servlet implementation class ChangePasswordCheck
 */
@WebServlet("/ChangePasswordCheck.html")
public class ChangePasswordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String old_password=request.getParameter("old_password");
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("session_member");
		WebMemberService webMemberService=new WebMemberService();
		member=webMemberService.load(member.getMember_id());
		Map<String,Object> map=new HashMap<String, Object>();
		if(member.getMember_password().equals(old_password)){
			map.put("flag", "success");
			map.put("message", "原密码正确，请设置新密码");
		}else{
			map.put("flag", "error");
			map.put("message", "密码不正确，请重新设置");
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		out.write(gson.toJson(map));
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
