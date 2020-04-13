package com.gs.tour.shxt.recruit.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.recruit.model.Recruit;

public class RecruitDao {
	/**查询招聘信息*/
	public PageBean getAllRecruitList(Recruit recruit,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from recruit where 1=1 ");
		if(recruit.getRecruit_company()!=null&&recruit.getRecruit_company().trim().length()>0){
			sb.append(" and recruit_company like '%"+StringEscapeUtils.escapeSql(recruit.getRecruit_company())+"%'");
		}
		if(recruit.getRecruit_status()!=null){
			sb.append(" and recruit_status like '%"+StringEscapeUtils.escapeSql(recruit.getRecruit_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Recruit> recruitList=new ArrayList<Recruit>();
			for (Map<String,Object> map : list) {
				Recruit r=new Recruit();
				try {
					BeanUtils.populate(r, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				recruitList.add(r);
			}
			pageBean.setData(recruitList);
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
	/**添加招聘信息*/
	public Integer addRecruit(Recruit recruit){
		String sql="insert into recruitbenefit (recruitBenefit_benefit) values (?)";
		DBUtil.executeUpdate(sql, recruit.getRecruit_benefit());
		String sql1="insert into recruit (recruit_company,recruit_position,recruit_salary,recruit_address,recruit_desc,recruit_benefit,recruit_date,recruit_email) values (?,?,?,?,?,?,?,?)";
		return DBUtil.executeUpdate(sql1, new Object[]{
				recruit.getRecruit_company().trim(),
				recruit.getRecruit_position().trim(),
				recruit.getRecruit_salary().trim(),
				recruit.getRecruit_address().trim(),
				recruit.getRecruit_desc().trim(),
				recruit.getRecruit_benefit().trim(),
				recruit.getRecruit_date().trim(),
				recruit.getRecruit_email().trim()
		});
	}
	/**根据招聘信息id获取角色*/
	public Recruit queryRecruitByRecruitId(Integer recruit_id){
		String sql="select * from recruit where recruit_id=?";
		Map<String,Object> map=DBUtil.query(sql,recruit_id);
		if(map!=null&&map.size()>0){
			Recruit recruit=new Recruit();
			try {
				BeanUtils.populate(recruit, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return recruit;
		}else{
			return null;
		}
	}
	/**更改招聘信息状态*/
	public void updateStatus(Integer recruit_id,Integer recruit_status){
		String sql="update recruit set recruit_status=? where recruit_id=?";
		DBUtil.executeUpdate(sql, new Object[]{recruit_status,recruit_id});
	}
	/**编辑招聘信息*/
	public Integer updateRecruit(Recruit recruit){
		String sql="update recruit set recruit_company=?,recruit_position=?,recruit_salary=?,recruit_address=?,recruit_desc=?,recruit_date=?,recruit_email=? where recruit_id=?";
		return DBUtil.executeUpdate(sql, new Object[]{
				recruit.getRecruit_company().trim(),
				recruit.getRecruit_position().trim(),
				recruit.getRecruit_salary().trim(),
				recruit.getRecruit_address().trim(),
				recruit.getRecruit_desc().trim(),
				recruit.getRecruit_date().trim(),
				recruit.getRecruit_email().trim(),
				recruit.getRecruit_id()
		});
	}
}
