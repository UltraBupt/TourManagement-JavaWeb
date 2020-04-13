package com.gs.tour.shxt.branch.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.branch.service.BranchService;

/**
 * Servlet implementation class BranchUpdateServlet
 */
@WebServlet("/BranchUpdateServlet.shxt")
public class BranchUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch_id=request.getParameter("branch_id");
		BranchService branchService=new BranchService();
		request.setAttribute("branch", branchService.queryBranchByBranchId(Integer.parseInt(branch_id)));
		request.getRequestDispatcher("WEB-INF/jsp/branch/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch_name=request.getParameter("branch_name");
		String branch_desc=request.getParameter("branch_desc");
		String branch_id=request.getParameter("branch_id");
		BranchService branchService=new BranchService();
		try {
			branchService.updateBranch(branch_name, branch_desc, Integer.parseInt(branch_id));
			request.setAttribute("flg", "success");
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			request.setAttribute("flg", "error");
			request.setAttribute("message", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
