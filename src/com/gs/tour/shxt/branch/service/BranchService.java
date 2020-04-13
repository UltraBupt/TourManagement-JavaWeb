package com.gs.tour.shxt.branch.service;

import java.util.List;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.branch.dao.BranchDao;
import com.gs.tour.shxt.branch.model.Branch;

public class BranchService {
	BranchDao branchDao=new BranchDao();
	/**查询部门列表*/
	public PageBean getAllBranchList(Branch branch,PageBean pageBean){
		return this.branchDao.getAllBranchList(branch, pageBean);
	}
	/**查询全部可用部门*/
	public List<Branch> getBranchList(){
		return this.branchDao.getBranchList();
	}
	/**验证部门名是否重复
	 * @throws Exception */
	public void checkBranchName(String branch_name) throws Exception{
		Integer num=this.branchDao.checkBranchName(branch_name);
		if(num>0){
			throw new Exception("部门名已存在，请重新输入");
		}
	}
	/**添加部门
	 * @throws Exception */
	public void addBranch(String branch_name,String branch_desc) throws Exception{
		Integer num=this.branchDao.addBranch(branch_name, branch_desc);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**根据部门id获取角色*/
	public Branch queryBranchByBranchId(Integer branch_id){
		return this.branchDao.queryBranchByBranchId(branch_id);
	}
	/**编辑部门
	 * @throws Exception */
	public void updateBranch(String branch_name,String branch_desc,Integer branch_id) throws Exception{
		Integer num=this.branchDao.updateBranch(branch_name,branch_desc, branch_id);
		if(num<=0){
			throw new Exception("编辑失败");
		}
	}
	/**更改部门状态*/
	public Integer updateStatus(Integer branch_id) throws Exception {
		Branch branch = this.branchDao.queryBranchByBranchId(branch_id);
		Integer branch_status = branch.getBranch_status();
		if(branch_status==1){
			branch_status=0;
		}else{
			branch_status=1;
		}
		this.branchDao.updateStatus(branch_id, branch_status);
		return branch_status;
	}
}
