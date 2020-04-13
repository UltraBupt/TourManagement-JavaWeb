package com.gs.tour.shxt.outboundtourism.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.outboundtourism.model.OutboundTourism;
import com.gs.tour.shxt.outboundtourism.service.OutboundTourismService;

/**
 * Servlet implementation class OutboundTourismUpdateServlet
 */
@WebServlet("/OutboundTourismUpdateServlet.shxt")
public class OutboundTourismUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outboundTourism_id=request.getParameter("outboundTourism_id");
		OutboundTourismService outboundTourismService=new OutboundTourismService();
		request.setAttribute("outboundTourism", outboundTourismService.load(Integer.parseInt(outboundTourism_id)));
		request.getRequestDispatcher("WEB-INF/jsp/outboundTourism/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outboundTourism_id=request.getParameter("outboundTourism_id");
		String outboundTourism_desc=request.getParameter("outboundTourism_desc");
		OutboundTourism outboundTourism=new OutboundTourism();
		outboundTourism.setOutboundTourism_desc(outboundTourism_desc);
		outboundTourism.setOutboundTourism_id(Integer.parseInt(outboundTourism_id));
		OutboundTourismService outboundTourismService=new OutboundTourismService();
		outboundTourismService.update(outboundTourism);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
