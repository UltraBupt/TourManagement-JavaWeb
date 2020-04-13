package com.gs.tour.shxt.advertisement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.advertisement.model.Advertisement;
import com.gs.tour.shxt.advertisement.service.AdvertisementService;

/**
 * Servlet implementation class AdvertisementAddServlet
 */
@WebServlet("/AdvertisementAddServlet.shxt")
public class AdvertisementAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String advertisement_id=request.getParameter("advertisement_id");
		AdvertisementService advertisementService=new AdvertisementService();
		request.setAttribute("advertisement", advertisementService.load(Integer.parseInt(advertisement_id)));
		request.getRequestDispatcher("WEB-INF/jsp/advertisement/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String advertisement_id=request.getParameter("advertisement_id");
		String advertisement_benefit=request.getParameter("advertisement_benefit");
		String advertisement_desc=request.getParameter("advertisement_desc");
		Advertisement advertisement=new Advertisement();
		advertisement.setAdvertisement_id(Integer.parseInt(advertisement_id));
		advertisement.setAdvertisement_desc(advertisement_desc);
		advertisement.setAdvertisement_benefit(advertisement_benefit);
		AdvertisementService advertisementService=new AdvertisementService();
		try {
			advertisementService.add(advertisement);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("flg", "error");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
