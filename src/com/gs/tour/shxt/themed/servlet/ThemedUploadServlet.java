package com.gs.tour.shxt.themed.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.util.UpLoadUtil;
import com.gs.tour.shxt.themed.service.ThemedService;

/**
 * Servlet implementation class ThemedUploadServlet
 */
@WebServlet("/ThemedUploadServlet.shxt")
public class ThemedUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("themed_id", request.getParameter("themed_id"));
		request.getRequestDispatcher("WEB-INF/jsp/themed/upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath="/resource/upload/photo";
		String localPath="D:/shxt_web/Tour/WebContent/resource/upload/photo";
		Map<String,Object> map=UpLoadUtil.upload(request, realPath, localPath);
		ThemedService themedService=new ThemedService();
		try {
			themedService.upload(map);
			request.setAttribute("flg", "success");
			request.setAttribute("message", "上传成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}

}
