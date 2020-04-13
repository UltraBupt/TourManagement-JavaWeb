package com.gs.tour.shxt.faster.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.faster.model.Faster;
import com.gs.tour.shxt.faster.service.FasterService;
import com.gs.tour.shxt.base.model.PageBean;

/**
 * Servlet implementation class FasterServlet
 */
@WebServlet("/FasterServlet.shxt")
public class FasterServlet extends HttpServlet {
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
		String faster_point=request.getParameter("faster_point");
		String faster_status=request.getParameter("faster_status");
		Faster faster=new Faster();
		if(faster_point!=null&&faster_point.trim().length()>0){
			faster.setFaster_point(faster_point);
		}
		if(faster_status!=null&&faster_status.trim().length()>0){
			faster.setFaster_status(Integer.parseInt(faster_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		FasterService fasterService=new FasterService();
		request.setAttribute("pageBean", fasterService.getAllFasterList(faster, pageBean));
		request.setAttribute("queryFaster", faster);
		request.getRequestDispatcher("WEB-INF/jsp/faster/list.jsp").forward(request, response);
	}

}
