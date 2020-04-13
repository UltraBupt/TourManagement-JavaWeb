package com.gs.tour.shxt.agricola.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.agricola.model.Agricola;
import com.gs.tour.shxt.agricola.service.AgricolaService;
import com.gs.tour.shxt.base.model.PageBean;

/**
 * Servlet implementation class AgricolaServlet
 */
@WebServlet("/AgricolaServlet.shxt")
public class AgricolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agricola_name=request.getParameter("agricola_name");
		String agricola_status=request.getParameter("agricola_status");
		Agricola agricola=new Agricola();
		if(agricola_name!=null&&agricola_name.trim().length()>0){
			agricola.setAgricola_name(agricola_name);
		}
		if(agricola_status!=null&&agricola_status.trim().length()>0){
			agricola.setAgricola_status(Integer.parseInt(agricola_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		AgricolaService agricolaService=new AgricolaService();
		request.setAttribute("pageBean", agricolaService.getAllAgricolaList(agricola, pageBean));
		request.setAttribute("queryAgricola", agricola);
		request.getRequestDispatcher("WEB-INF/jsp/agricola/list.jsp").forward(request, response);
	}

}
