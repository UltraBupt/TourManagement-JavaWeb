package com.gs.tour.shxt.faster.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.faster.model.Faster;
import com.gs.tour.shxt.faster.service.FasterService;

/**
 * Servlet implementation class FasterAddServlet
 */
@WebServlet("/FasterAddServlet.shxt")
public class FasterAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/faster/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String faster_from=request.getParameter("faster_from");
		String faster_to=request.getParameter("faster_to");
		String faster_price=request.getParameter("faster_price");
		String faster_time=request.getParameter("faster_time");
		String faster_point=request.getParameter("faster_point");
		Faster faster=new Faster();
		faster.setFaster_from(faster_from);
		faster.setFaster_to(faster_to);
		faster.setFaster_price(faster_price);
		faster.setFaster_time(faster_time);
		faster.setFaster_point(faster_point);
		FasterService fasterService=new FasterService();
		try {
			fasterService.addFaster(faster);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
