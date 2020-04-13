package com.gs.tour.shxt.quick.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.quick.model.Quick;
import com.gs.tour.shxt.quick.service.QuickService;

/**
 * Servlet implementation class QuickUpdateServlet
 */
@WebServlet("/QuickUpdateServlet.shxt")
public class QuickUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quick_id=request.getParameter("quick_id");
		QuickService quickService=new QuickService();
		request.setAttribute("quick",quickService.load(Integer.parseInt(quick_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/quick/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quick_name=request.getParameter("quick_name");
		String quick_price=request.getParameter("quick_price");
		String quick_address=request.getParameter("quick_address");
		String quick_desc=request.getParameter("quick_desc");
		String quick_id=request.getParameter("quick_id");
		Quick quick=new Quick();
		quick.setQuick_name(quick_name);
		quick.setQuick_price(quick_price);
		quick.setQuick_address(quick_address);
		quick.setQuick_desc(quick_desc);
		quick.setQuick_id(Integer.parseInt(quick_id));
		QuickService quickService=new QuickService();
		quickService.update(quick);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
