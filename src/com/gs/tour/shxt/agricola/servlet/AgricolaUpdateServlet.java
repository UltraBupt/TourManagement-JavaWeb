package com.gs.tour.shxt.agricola.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.agricola.model.Agricola;
import com.gs.tour.shxt.agricola.service.AgricolaService;

/**
 * Servlet implementation class AgricolaUpdateServlet
 */
@WebServlet("/AgricolaUpdateServlet.shxt")
public class AgricolaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agricola_id=request.getParameter("agricola_id");
		AgricolaService agricolaService=new AgricolaService();
		request.setAttribute("agricola",agricolaService.load(Integer.parseInt(agricola_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/agricola/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agricola_name=request.getParameter("agricola_name");
		String agricola_price=request.getParameter("agricola_price");
		String agricola_address=request.getParameter("agricola_address");
		String agricola_desc=request.getParameter("agricola_desc");
		String agricola_id=request.getParameter("agricola_id");
		Agricola agricola=new Agricola();
		agricola.setAgricola_name(agricola_name);
		agricola.setAgricola_price(agricola_price);
		agricola.setAgricola_address(agricola_address);
		agricola.setAgricola_desc(agricola_desc);
		agricola.setAgricola_id(Integer.parseInt(agricola_id));
		AgricolaService agricolaService=new AgricolaService();
		agricolaService.update(agricola);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
