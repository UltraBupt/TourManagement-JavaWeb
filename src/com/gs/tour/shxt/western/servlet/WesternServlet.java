package com.gs.tour.shxt.western.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.western.model.Western;
import com.gs.tour.shxt.western.service.WesternService;

/**
 * Servlet implementation class WesternServlet
 */
@WebServlet("/WesternServlet.shxt")
public class WesternServlet extends HttpServlet {
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
		String western_name=request.getParameter("western_name");
		String western_status=request.getParameter("western_status");
		Western western=new Western();
		if(western_name!=null&&western_name.trim().length()>0){
			western.setWestern_name(western_name);
		}
		if(western_status!=null&&western_status.trim().length()>0){
			western.setWestern_status(Integer.parseInt(western_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
    	WesternService westernService=new WesternService();
		request.setAttribute("pageBean", westernService.getAllWesternList(western, pageBean));
		request.setAttribute("queryWestern", western);
		request.getRequestDispatcher("WEB-INF/jsp/western/list.jsp").forward(request, response);
	}

}
