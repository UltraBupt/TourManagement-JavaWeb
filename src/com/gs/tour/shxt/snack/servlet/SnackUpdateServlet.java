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
 * Servlet implementation class SnackUpdateServlet
 */
@WebServlet("/SnackUpdateServlet.shxt")
public class SnackUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String snack_id=request.getParameter("snack_id");
		SnackService snackService=new SnackService();
		request.setAttribute("snack",snackService.load(Integer.parseInt(snack_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/snack/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String snack_name=request.getParameter("snack_name");
		String snack_price=request.getParameter("snack_price");
		String snack_address=request.getParameter("snack_address");
		String snack_desc=request.getParameter("snack_desc");
		String snack_id=request.getParameter("snack_id");
		Snack snack=new Snack();
		snack.setSnack_name(snack_name);
		snack.setSnack_price(snack_price);
		snack.setSnack_address(snack_address);
		snack.setSnack_desc(snack_desc);
		snack.setSnack_id(Integer.parseInt(snack_id));
		SnackService snackService=new SnackService();
		snackService.update(snack);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
