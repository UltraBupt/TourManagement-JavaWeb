package com.gs.tour.shxt.leave.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.leave.model.Leave;
import com.gs.tour.shxt.user.model.User;

public class LeaveDao {
	/**查询请假列表*/
	public PageBean getAllLeaveList(Leave leave,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from leave_ where 1=1 ");
		if(leave.getLeave_name()!=null&&leave.getLeave_name().trim().length()>0){
			sb.append(" and leave_name like '%"+StringEscapeUtils.escapeSql(leave.getLeave_name())+"%'");
		}
		if(leave.getLeave_day()!=null&&leave.getLeave_day().trim().length()>0){
			sb.append(" and leave_day like '%"+StringEscapeUtils.escapeSql(leave.getLeave_day())+"%'");
		}
		if(leave.getLeave_status()!=null){
			sb.append(" and leave_status like '%"+StringEscapeUtils.escapeSql(leave.getLeave_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Leave> leaveList=new ArrayList<Leave>();
			for (Map<String,Object> map : list) {
				Leave l=new Leave();
				try {
					BeanUtils.populate(l, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				leaveList.add(l);
			}
			pageBean.setData(leaveList);
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
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Leave load(Integer leave_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from leave_ where leave_id=?";
		Map<String,Object> map=DBUtil.query(sql, leave_id);
		Leave leave=new Leave();
		BeanUtils.populate(leave, map);
		return leave;
	}
	/**处理假条*/
	public void operator(Leave leave){
		String sql="update leave_ set leave_status=? where leave_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				leave.getLeave_status(),
				leave.getLeave_id()
		});
	}
	/**创建假条*/
	public Integer addLeave(Leave leave,User user){
		String sql1="select branch_name from branch where branch_id=?";
		String branch_name=DBUtil.query(sql1, user.getFk_org_id()).get("branch_name").toString();
		String sql2="select role_name from role where role_id=?";
		String role_name=DBUtil.query(sql2,user.getFk_role_id()).get("role_name").toString();
		String sql="insert into leave_ (leave_name,leave_branch,leave_role,leave_day,leave_desc,leave_startDay,leave_overDay) values (?,?,?,?,?,?,?)";
		return DBUtil.executeUpdate(sql,new Object[]{
				user.getUser_name(),
				branch_name,
				role_name,
				leave.getLeave_day(),
				leave.getLeave_desc(),
				leave.getLeave_startDay(),
				leave.getLeave_overDay()
		});
	}
}
