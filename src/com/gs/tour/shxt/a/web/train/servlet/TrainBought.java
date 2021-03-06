package com.gs.tour.shxt.a.web.train.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.a.web.train.service.WebTrainService;

/**
 * Servlet implementation class TrainBought
 */
@WebServlet("/TrainBought.html")
public class TrainBought extends HttpServlet {
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
		String train_id=request.getParameter("train_id");
		WebTrainService webTrainServcie=new WebTrainService();
		request.setAttribute("train", webTrainServcie.queryTrainByTrainId(Integer.parseInt(train_id)));
		request.getRequestDispatcher("WEB-INF/web/train/trainBought.jsp").forward(request, response);
	}

}
