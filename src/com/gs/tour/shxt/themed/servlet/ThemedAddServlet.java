package com.gs.tour.shxt.themed.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.themed.model.Themed;
import com.gs.tour.shxt.themed.service.ThemedService;

/**
 * Servlet implementation class ThemedAddServlet
 */
@WebServlet("/ThemedAddServlet.shxt")
public class ThemedAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/themed/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String themed_name=request.getParameter("themed_name");
		String themed_price=request.getParameter("themed_price");
		String themed_address=request.getParameter("themed_address");
		String themed_desc=request.getParameter("themed_desc");
		Themed themed=new Themed();
		themed.setThemed_name(themed_name);
		themed.setThemed_price(themed_price);
		themed.setThemed_address(themed_address);
		themed.setThemed_desc(themed_desc);
		ThemedService themedService=new ThemedService();
		try {
			themedService.addThemed(themed);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
