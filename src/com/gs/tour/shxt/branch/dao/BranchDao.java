package com.gs.tour.shxt.branch.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.branch.model.Branch;

public class BranchDao {
	/**查询部门列表*/
	public PageBean getAllBranchList(Branch branch,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from branch where 1=1 ");
		if(branch.getBranch_name()!=null&&branch.getBranch_name().trim().length()>0){
			sb.append(" and branch_name like '%"+StringEscapeUtils.escapeSql(branch.getBranch_name())+"%'");
		}
		if(branch.getBranch_status()!=null){
			sb.append(" and branch_status like '%"+StringEscapeUtils.escapeSql(branch.getBranch_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Branch> branchList=new ArrayList<Branch>();
			for (Map<String,Object> map : list) {
				Branch b=new Branch();
				try {
					BeanUtils.populate(b, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				branchList.add(b);
			}
			pageBean.setData(branchList);
			String countSql="select count(*) as num from ("+sb.toString()+")t";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPage);
			return pageBean;
		}else{
			return null;
		}
	}
	/**查询全部可用部门*/
	public List<Branch> getBranchList(){
		String sql="select * from branch where branch_status=1 ";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Branch> branchList=new ArrayList<Branch>();
			for (Map<String,Object> map : list) {
				Branch b=new Branch();
				try {
					BeanUtils.populate(b, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				branchList.add(b);
			}
			return branchList;
		}else{
			return null;
		}
	}
	/**添加部门*/
	public Integer addBranch(String branch_name,String branch_desc){
		String sql="insert into branch (branch_name,branch_desc) values (?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				branch_name.trim(),
				branch_desc
		});
	}
	/**验证部门名是否重复*/
	public Integer checkBranchName(String branch_name){
		String sql="select count(1) as num from branch where branch_name=?";
		return Integer.parseInt(DBUtil.query(sql, branch_name).get("num").toString());
	}
	/**根据部门id获取角色*/
	public Branch queryBranchByBranchId(Integer branch_id){
		String sql="select * from branch where branch_id=?";
		Map<String,Object> map=DBUtil.query(sql,branch_id);
		if(map!=null&&map.size()>0){
			Branch branch=new Branch();
			try {
				BeanUtils.populate(branch, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return branch;
		}else{
			return null;
		}
	}
	/**编辑角色*/
	public Integer updateBranch(String branch_name,String branch_desc,Integer branch_id){
		String sql="update branch set branch_name=?,branch_desc=? where branch_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				branch_name.trim(),
				branch_desc,
				branch_id
		});
	}
	/**更改部门状态*/
	public void updateStatus(Integer branch_id,Integer branch_status) throws Exception{
		String sql="update branch set branch_status=? where branch_id=?";
		DBUtil.executeUpdate(sql, new Object[]{branch_status,branch_id});
	}
}
