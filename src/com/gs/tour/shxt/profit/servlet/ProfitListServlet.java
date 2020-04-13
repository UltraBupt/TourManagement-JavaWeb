package com.gs.tour.shxt.profit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.profit.service.ProfitService;
import com.gs.tour.shxt.sumprofit.service.SumProfitService;

/**
 * Servlet implementation class ProfitListServlet
 */
@WebServlet("/ProfitListServlet.shxt")
public class ProfitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfitService profitService=new ProfitService();
		SumProfitService sumProfitService=new SumProfitService();
		request.setAttribute("aroundTourismProfit", profitService.getAroundTourismProfit());
		request.setAttribute("inboundTourismProfit", profitService.getInboundTourismProfit());
		request.setAttribute("outboundTourismProfit", profitService.getOutboundTourismProfit());
		request.setAttribute("insuranceProfit", profitService.getInsuranceProfit());
		request.setAttribute("visaProfit", profitService.getVisaProfit());
		request.setAttribute("financeProfit", profitService.getFinanceProfit());
		request.setAttribute("snackProfit", profitService.getSnackProfit());
		request.setAttribute("quickProfit", profitService.getQuickProfit());
		request.setAttribute("buffetProfit", profitService.getBuffetProfit());
		request.setAttribute("themedProfit", profitService.getThemedProfit());
		request.setAttribute("westernProfit", profitService.getWesternProfit());
		request.setAttribute("holidayProfit", profitService.getHolidayProfit());
		request.setAttribute("apartmentProfit", profitService.getApartmentProfit());
		request.setAttribute("villaProfit", profitService.getVillaProfit());
		request.setAttribute("agricolaProfit", profitService.getAgricolaProfit());
		request.setAttribute("hotelProfit", profitService.getHotelProfit());
		request.setAttribute("airlineProfit", profitService.getAirlineProfit());
		request.setAttribute("trainProfit", profitService.getTrainProfit());
		request.setAttribute("shipProfit", profitService.getShipProfit());
		request.setAttribute("busProfit", profitService.getBusProfit());
		request.setAttribute("fasterProfit", profitService.getFasterProfit());
		request.setAttribute("advertisementProfit", profitService.getAdvertisementProfit());
		request.setAttribute("recruitProfit", profitService.getRecruitProfit());
		request.setAttribute("sum", sumProfitService.getSumProfit());
		request.getRequestDispatcher("WEB-INF/jsp/profit/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
