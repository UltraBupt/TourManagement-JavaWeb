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
 * Servlet implementation class ThemedUpdateServlet
 */
@WebServlet("/ThemedUpdateServlet.shxt")
public class ThemedUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String themed_id=request.getParameter("themed_id");
		ThemedService themedService=new ThemedService();
		request.setAttribute("themed",themedService.load(Integer.parseInt(themed_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/themed/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String themed_name=request.getParameter("themed_name");
		String themed_price=request.getParameter("themed_price");
		String themed_address=request.getParameter("themed_address");
		String themed_desc=request.getParameter("themed_desc");
		String themed_id=request.getParameter("themed_id");
		Themed themed=new Themed();
		themed.setThemed_name(themed_name);
		themed.setThemed_price(themed_price);
		themed.setThemed_address(themed_address);
		themed.setThemed_desc(themed_desc);
		themed.setThemed_id(Integer.parseInt(themed_id));
		ThemedService themedService=new ThemedService();
		themedService.update(themed);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
