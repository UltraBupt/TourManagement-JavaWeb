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
 * Servlet implementation class TrainUpdateServlet
 */
@WebServlet("/TrainUpdateServlet.shxt")
public class TrainUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String train_id=request.getParameter("train_id");
		TrainService trainService=new TrainService();
		request.setAttribute("train",trainService.load(Integer.parseInt(train_id)) );
		request.getRequestDispatcher("WEB-INF/jsp/train/update.jsp").forward(request, response);
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
		String train_id=request.getParameter("train_id");
		Train train=new Train();
		train.setTrain_from(train_from);
		train.setTrain_to(train_to);
		train.setTrain_price(train_price);
		train.setTrain_time(train_time);
		train.setTrain_point(train_point);
		train.setTrain_id(Integer.parseInt(train_id));
		TrainService trainService=new TrainService();
		trainService.update(train);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "修改成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
