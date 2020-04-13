package com.gs.tour.shxt.message.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.message.model.NewMessage;
import com.gs.tour.shxt.message.service.NewMessageService;

/**
 * Servlet implementation class MessageListServlet
 */
@WebServlet("/MessageListServlet.shxt")
public class MessageListServlet extends HttpServlet {
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
		//查询数据
		String newMessage_status=request.getParameter("newMessage_status");
		NewMessage newMessage=new NewMessage();
		if(newMessage_status!=null&&newMessage_status.trim().length()>0){
			newMessage.setNewMessage_status(Integer.parseInt(newMessage_status));
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		NewMessageService newMessageService=new NewMessageService();
		request.setAttribute("pageBean", newMessageService.getAllNewMessageList(newMessage, pageBean));
		request.setAttribute("queryNewMessage", newMessage);
		request.getRequestDispatcher("WEB-INF/jsp/message/list.jsp").forward(request, response);
	}

}
