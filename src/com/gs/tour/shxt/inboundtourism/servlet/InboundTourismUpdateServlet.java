package com.gs.tour.shxt.inboundtourism.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.inboundtourism.model.InboundTourism;
import com.gs.tour.shxt.inboundtourism.service.InboundTourismService;

/**
 * Servlet implementation class InboundTourismUpdateServlet
 */
@WebServlet("/InboundTourismUpdateServlet.shxt")
public class InboundTourismUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inboundTourism_id=request.getParameter("inboundTourism_id");
		InboundTourismService inboundTourismService=new InboundTourismService();
		request.setAttribute("inboundTourism", inboundTourismService.load(Integer.parseInt(inboundTourism_id)));
		request.getRequestDispatcher("WEB-INF/jsp/inboundTourism/update.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inboundTourism_id=request.getParameter("inboundTourism_id");
		String inboundTourism_desc=request.getParameter("inboundTourism_desc");
		InboundTourism inboundTourism=new InboundTourism();
		inboundTourism.setInboundTourism_desc(inboundTourism_desc);
		inboundTourism.setInboundTourism_id(Integer.parseInt(inboundTourism_id));
		InboundTourismService inboundTourismService=new InboundTourismService();
		inboundTourismService.update(inboundTourism);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
