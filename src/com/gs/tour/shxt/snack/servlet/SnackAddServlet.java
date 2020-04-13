package com.gs.tour.shxt.snack.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.snack.model.Snack;
import com.gs.tour.shxt.snack.service.SnackService;

/**
 * Servlet implementation class SnackAddServlet
 */
@WebServlet("/SnackAddServlet.shxt")
public class SnackAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/snack/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String snack_name=request.getParameter("snack_name");
		String snack_price=request.getParameter("snack_price");
		String snack_address=request.getParameter("snack_address");
		String snack_desc=request.getParameter("snack_desc");
		Snack snack=new Snack();
		snack.setSnack_name(snack_name);
		snack.setSnack_price(snack_price);
		snack.setSnack_address(snack_address);
		snack.setSnack_desc(snack_desc);
		SnackService snackService=new SnackService();
		try {
			snackService.addSnack(snack);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
