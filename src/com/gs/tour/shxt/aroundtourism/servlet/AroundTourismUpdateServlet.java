package com.gs.tour.shxt.aroundtourism.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.aroundtourism.model.AroundTourism;
import com.gs.tour.shxt.aroundtourism.service.AroundTourismService;

/**
 * Servlet implementation class AroundTourismUpdateServlet
 */
@WebServlet("/AroundTourismUpdateServlet.shxt")
public class AroundTourismUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aroundTourism_id=request.getParameter("aroundTourism_id");
		AroundTourismService aroundTourismService=new AroundTourismService();
		request.setAttribute("aroundTourism", aroundTourismService.load(Integer.parseInt(aroundTourism_id)));
		request.getRequestDispatcher("WEB-INF/jsp/aroundTourism/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aroundTourism_id=request.getParameter("aroundTourism_id");
		String aroundTourism_desc=request.getParameter("aroundTourism_desc");
		AroundTourism aroundTourism=new AroundTourism();
		aroundTourism.setAroundTourism_desc(aroundTourism_desc);
		aroundTourism.setAroundTourism_id(Integer.parseInt(aroundTourism_id));
		AroundTourismService aroundTourismService=new AroundTourismService();
		aroundTourismService.update(aroundTourism);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
