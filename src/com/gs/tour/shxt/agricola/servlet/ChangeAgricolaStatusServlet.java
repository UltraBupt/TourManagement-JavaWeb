package com.gs.tour.shxt.agricola.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gs.tour.shxt.agricola.service.AgricolaService;

/**
 * Servlet implementation class ChangeAgricolaStatusServlet
 */
@WebServlet("/ChangeAgricolaStatusServlet.shxt")
public class ChangeAgricolaStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agricola_id = request.getParameter("agricola_id");
		AgricolaService agricolaService=new AgricolaService();
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			Integer agricola_status = agricolaService.updateStatus(Integer.parseInt(agricola_id));
			map.put("flag", "success");
			map.put("agricola_status",agricola_status);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "error");
			map.put("message",e.getMessage());
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.write(gson.toJson(map));
		out.flush();
		out.close();
	}

}
