package com.gs.tour.shxt.member.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.member.model.Member;

public class MemberDao {
	/**查询会员列表*/
	public PageBean getAllMemberList(Member member,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from member where 1=1 ");
		if(member.getMember_type()!=null&&member.getMember_type().trim().length()>0){
			sb.append(" and member_type like '%"+StringEscapeUtils.escapeSql(member.getMember_type())+"%'");
		}
		if(member.getMember_account()!=null&&member.getMember_account().trim().length()>0){
			sb.append(" and member_account like '%"+StringEscapeUtils.escapeSql(member.getMember_account())+"%'");
		}
		if(member.getMember_status()!=null){
			sb.append(" and member_status like '%"+StringEscapeUtils.escapeSql(member.getMember_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Member> memberList=new ArrayList<Member>();
			for (Map<String,Object> map : list) {
				Member m=new Member();
				try {
					BeanUtils.populate(m, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				memberList.add(m);
			}
			pageBean.setData(memberList);
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
	/**根据会员id获取角色*/
	public Member queryMemberByMemberId(Integer member_id){
		String sql="select * from member where member_id=?";
		Map<String,Object> map=DBUtil.query(sql,member_id);
		if(map!=null&&map.size()>0){
			Member member=new Member();
			try {
				BeanUtils.populate(member, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return member;
		}else{
			return null;
		}
	}
	/**更改会员状态*/
	public void updateStatus(Integer member_id,Integer member_status) throws Exception{
		String sql="update member set member_status=? where member_id=?";
		DBUtil.executeUpdate(sql, new Object[]{member_status,member_id});
	}
}
