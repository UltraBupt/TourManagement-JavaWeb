package com.gs.tour.shxt.snack.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.snack.model.Snack;
import com.gs.tour.shxt.snack.service.SnackService;

/**
 * Servlet implementation class SnackServlet
 */
@WebServlet("/SnackServlet.shxt")
public class SnackServlet extends HttpServlet {
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
		String snack_name=request.getParameter("snack_name");
		String snack_status=request.getParameter("snack_status");
		Snack snack=new Snack();
		if(snack_name!=null&&snack_name.trim().length()>0){
			snack.setSnack_name(snack_name);
		}
		if(snack_status!=null&&snack_status.trim().length()>0){
			snack.setSnack_status(Integer.parseInt(snack_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		SnackService snackService=new SnackService();
		request.setAttribute("pageBean", snackService.getAllSnackList(snack, pageBean));
		request.setAttribute("querySnack", snack);
		request.getRequestDispatcher("WEB-INF/jsp/snack/list.jsp").forward(request, response);
	}

}
