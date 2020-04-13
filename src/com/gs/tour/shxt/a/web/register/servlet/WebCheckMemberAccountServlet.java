package com.gs.tour.shxt.a.web.register.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gs.tour.shxt.a.web.register.service.WebRegisterService;

/**
 * Servlet implementation class WebCheckMemberAccountServlet
 */
@WebServlet("/WebCheckMemberAccountServlet.html")
public class WebCheckMemberAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_account=request.getParameter("member_account");
		WebRegisterService webRegisterService=new WebRegisterService();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			webRegisterService.checkMemberAccount(member_account);
			System.out.println(111);
			map.put("flg", true);
		} catch (Exception e) {
			map.put("flg", false);
			map.put("message", e.getMessage());
		}
		out.write(gson.toJson(map));
		out.flush();
		out.close();
	}
}
