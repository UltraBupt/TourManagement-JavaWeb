package com.gs.tour.shxt.train.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.train.model.Train;
import com.gs.tour.shxt.train.service.TrainService;

/**
 * Servlet implementation class TrainAddServlet
 */
@WebServlet("/TrainAddServlet.shxt")
public class TrainAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/train/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String train_from=request.getParameter("train_from");
		String train_to=request.getParameter("train_to");
		String train_price=request.getParameter("train_price");
		String train_time=request.getParameter("train_time");
		String train_point=request.getParameter("train_point");
		Train train=new Train();
		train.setTrain_from(train_from);
		train.setTrain_to(train_to);
		train.setTrain_price(train_price);
		train.setTrain_time(train_time);
		train.setTrain_point(train_point);
		TrainService trainService=new TrainService();
		try {
			trainService.addTrain(train);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
