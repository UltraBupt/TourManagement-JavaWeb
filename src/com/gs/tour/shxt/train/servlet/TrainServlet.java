package com.gs.tour.shxt.train.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.train.model.Train;
import com.gs.tour.shxt.train.service.TrainService;
import com.gs.tour.shxt.base.model.PageBean;

/**
 * Servlet implementation class TrainServlet
 */
@WebServlet("/TrainServlet.shxt")
public class TrainServlet extends HttpServlet {
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
		String train_point=request.getParameter("train_point");
		String train_status=request.getParameter("train_status");
		Train train=new Train();
		if(train_point!=null&&train_point.trim().length()>0){
			train.setTrain_point(train_point);
		}
		if(train_status!=null&&train_status.trim().length()>0){
			train.setTrain_status(Integer.parseInt(train_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		TrainService trainService=new TrainService();
		request.setAttribute("pageBean", trainService.getAllTrainList(train, pageBean));
		request.setAttribute("queryTrain", train);
		request.getRequestDispatcher("WEB-INF/jsp/train/list.jsp").forward(request, response);
	}

}
