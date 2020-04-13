package com.gs.tour.shxt.salary.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.salary.model.Salary;

public class SalaryDao {
	/**查询薪资列表*/
	public PageBean getAllSalaryList(Salary salary,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from salary where 1=1 ");
		if(salary.getSalary_number()!=null&&salary.getSalary_number().trim().length()>0){
			sb.append(" and salary_number like '%"+StringEscapeUtils.escapeSql(salary.getSalary_number())+"%'");
		}
		if(salary.getPosition_name()!=null&&salary.getPosition_name().trim().length()>0){
			sb.append(" and position_name like '%"+StringEscapeUtils.escapeSql(salary.getPosition_name())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Salary> salaryList=new ArrayList<Salary>();
			for (Map<String,Object> map : list) {
				Salary s=new Salary();
				try {
					BeanUtils.populate(s, map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				salaryList.add(s);
			}
			pageBean.setData(salaryList);
			String countSql="select count(*) as num from ("+sb.toString()+")t";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPages=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPages);
			return pageBean;
		}else{
			return null;
		}
	}
	/**验证角色是否重复*/
	public Integer checkRole(Integer fk_role_id){
		String sql="select count(1) as num from salary where fk_role_id=?";
		Integer num=Integer.parseInt(DBUtil.query(sql,fk_role_id).get("num").toString());
		return num;
	}
	/**添加薪资*/
	public Integer addSalary(Integer fk_role_id,String salary_number){
		String sql="select role_name from role where role_id="+fk_role_id;
		String position_name=DBUtil.query(sql).get("role_name").toString();
		String sql1="insert into salary (fk_role_id,salary_number,position_name) values(?,?,?)";
		return DBUtil.executeUpdate(sql1, new Object[]{
				fk_role_id,
				salary_number.trim(),
				position_name.trim()
		});
	}
	/**根据薪资id获取薪资*/
	public Salary querySalaryBySalaryId(Integer salary_id){
		String sql="select * from salary where salary_id=?";
		Map<String,Object> map=DBUtil.query(sql,salary_id);
		if(map!=null&&map.size()>0){
			Salary salary=new Salary();
			try {
				BeanUtils.populate(salary, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return salary;
		}else{
			return null;
		}
	}
	/**编辑薪资*/
	public Integer updateSalary(String salary_number,Integer salary_id){
		String sql="update salary set salary_number=? where salary_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				salary_number.trim(),
				salary_id
		});
	}
	/**根据用户id获取用户薪资*/
	public Salary querySalaryByUserId(Integer user_id){
		String sql="select fk_salary_id from user where user_id=?";
		String salary_id=DBUtil.query(sql, user_id).get("fk_salary_id").toString();
		String sql1="select * from salary where salary_id=?";
		Map<String,Object> map=DBUtil.query(sql1,salary_id);
		if(map!=null&&map.size()>0){
			Salary salary=new Salary();
			try {
				BeanUtils.populate(salary, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return salary;
		}else{
			return null;
		}
	}
	
}
