package com.gs.tour.shxt.villa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.villa.model.Villa;
import com.gs.tour.shxt.villa.service.VillaService;

/**
 * Servlet implementation class VillaServlet
 */
@WebServlet("/VillaServlet.shxt")
public class VillaServlet extends HttpServlet {
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
		String villa_name=request.getParameter("villa_name");
		String villa_status=request.getParameter("villa_status");
		Villa villa=new Villa();
		if(villa_name!=null&&villa_name.trim().length()>0){
			villa.setVilla_name(villa_name);
		}
		if(villa_status!=null&&villa_status.trim().length()>0){
			villa.setVilla_status(Integer.parseInt(villa_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		VillaService villaService=new VillaService();
		request.setAttribute("pageBean", villaService.getAllVillaList(villa, pageBean));
		request.setAttribute("queryVilla", villa);
		request.getRequestDispatcher("WEB-INF/jsp/villa/list.jsp").forward(request, response);
	}

}
