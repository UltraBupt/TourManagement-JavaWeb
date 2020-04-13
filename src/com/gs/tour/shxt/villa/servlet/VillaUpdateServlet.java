package com.gs.tour.shxt.villa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.villa.model.Villa;
import com.gs.tour.shxt.villa.service.VillaService;

/**
 * Servlet implementation class VillaUpdateServlet
 */
@WebServlet("/VillaUpdateServlet.shxt")
public class VillaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String villa_id=request.getParameter("villa_id");
		VillaService villaService=new VillaService();
		request.setAttribute("villa",villaService.load(Integer.parseInt(villa_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/villa/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String villa_name=request.getParameter("villa_name");
		String villa_price=request.getParameter("villa_price");
		String villa_address=request.getParameter("villa_address");
		String villa_desc=request.getParameter("villa_desc");
		String villa_id=request.getParameter("villa_id");
		Villa villa=new Villa();
		villa.setVilla_name(villa_name);
		villa.setVilla_price(villa_price);
		villa.setVilla_address(villa_address);
		villa.setVilla_desc(villa_desc);
		villa.setVilla_id(Integer.parseInt(villa_id));
		VillaService villaService=new VillaService();
		villaService.update(villa);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
