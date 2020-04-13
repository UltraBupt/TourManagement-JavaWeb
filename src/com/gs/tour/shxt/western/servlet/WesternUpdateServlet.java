package com.gs.tour.shxt.western.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.western.model.Western;
import com.gs.tour.shxt.western.service.WesternService;

/**
 * Servlet implementation class WesternUpdateServlet
 */
@WebServlet("/WesternUpdateServlet.shxt")
public class WesternUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String western_id=request.getParameter("western_id");
		WesternService westernService=new WesternService();
		request.setAttribute("western",westernService.load(Integer.parseInt(western_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/western/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String western_name=request.getParameter("western_name");
		String western_price=request.getParameter("western_price");
		String western_address=request.getParameter("western_address");
		String western_desc=request.getParameter("western_desc");
		String western_id=request.getParameter("western_id");
		Western western=new Western();
		western.setWestern_name(western_name);
		western.setWestern_price(western_price);
		western.setWestern_address(western_address);
		western.setWestern_desc(western_desc);
		western.setWestern_id(Integer.parseInt(western_id));
		WesternService westernService=new WesternService();
		westernService.update(western);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
