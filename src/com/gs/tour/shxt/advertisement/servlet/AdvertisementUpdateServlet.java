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
 * Servlet implementation class AdvertisementUpdateServlet
 */
@WebServlet("/AdvertisementUpdateServlet.shxt")
public class AdvertisementUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String advertisement_id=request.getParameter("advertisement_id");
		AdvertisementService advertisementService=new AdvertisementService();
		request.setAttribute("advertisement", advertisementService.load(Integer.parseInt(advertisement_id)));
		request.getRequestDispatcher("WEB-INF/jsp/advertisement/update.jsp").forward(request, response);
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
		advertisement.setAdvertisement_benefit(advertisement_benefit);
		advertisement.setAdvertisement_desc(advertisement_desc);
		AdvertisementService advertisementService=new AdvertisementService();
		advertisementService.update(advertisement);
		request.setAttribute("flg", "success");
		request.setAttribute("message", "编辑成功！");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
