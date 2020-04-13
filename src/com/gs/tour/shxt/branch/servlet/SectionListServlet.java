package com.gs.tour.shxt.branch.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.branch.model.Branch;
import com.gs.tour.shxt.branch.service.BranchService;

/**
 * Servlet implementation class SectionListServlet
 */
@WebServlet("/SectionListServlet.shxt")
public class SectionListServlet extends HttpServlet {
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
		String branch_status=request.getParameter("branch_status");
		String branch_name=request.getParameter("branch_name");
		Branch branch=new Branch();
		if(branch_status!=null&&branch_status.trim().length()>0){
			branch.setBranch_status(Integer.parseInt(branch_status));
		}
		if(branch_name!=null&&branch_name.trim().length()>0){
			branch.setBranch_name(branch_name);
		}
		//接收分页数据
		String pageNow=request.getParameter("pageNow");
		PageBean pageBean=new PageBean();
		if(pageNow!=null){
			pageBean.setPageNow(Integer.parseInt(pageNow));
		}
		BranchService branchService=new BranchService();
		request.setAttribute("pageBean", branchService.getAllBranchList(branch, pageBean));
		request.setAttribute("queryBranch", branch);
		request.getRequestDispatcher("WEB-INF/jsp/branch/list.jsp").forward(request, response);
	}

}
