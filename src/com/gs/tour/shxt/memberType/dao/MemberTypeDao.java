package com.gs.tour.shxt.memberType.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.memberType.model.MemberType;

public class MemberTypeDao {
	/**查询会员类型列表*/
	public PageBean getAllMemberTypeList(MemberType memberType,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from memberType where 1=1 ");
		if(memberType.getMemberType_name()!=null&&memberType.getMemberType_name().trim().length()>0){
			sb.append(" and memberType_name like '%"+StringEscapeUtils.escapeSql(memberType.getMemberType_name())+"%'");
		}
		if(memberType.getMemberType_benefit()!=null&&memberType.getMemberType_benefit().trim().length()>0){
			sb.append(" and memberType_benefit like '%"+StringEscapeUtils.escapeSql(memberType.getMemberType_benefit())+"%'");
		}
		if(memberType.getMemberType_status()!=null){
			sb.append(" and memberType_status like '%"+StringEscapeUtils.escapeSql(memberType.getMemberType_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<MemberType> memberTypeList=new ArrayList<MemberType>();
			for (Map<String,Object> map : list) {
				MemberType m=new MemberType();
				try {
					BeanUtils.populate(m, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				memberTypeList.add(m);
			}
			pageBean.setData(memberTypeList);
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
	/**验证会员类型名称是否重复*/
	public Integer checkMemberTypeName(String memberType_name){
		String sql="select count(1) as num from memberType where memberType_name=?";
		Integer num=Integer.parseInt(DBUtil.query(sql,memberType_name.trim()).get("num").toString());
		return num;
	}
	/**添加会员类型*/
	public Integer addMemberType(String memberType_name,Integer memberType_number,String memberType_desc,String memberType_benefit){
		String sql="insert into memberType (memberType_name,memberType_number,memberType_desc,memberType_benefit) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				memberType_name.trim(),
				memberType_number,
				memberType_desc.trim(),
				memberType_benefit.trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public MemberType load(Integer memberType_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from memberType where memberType_id=?";
		Map<String,Object> map=DBUtil.query(sql,memberType_id);
		MemberType memberType=new MemberType();
		BeanUtils.populate(memberType, map);
		return memberType;
	}
	/**编辑会员类型*/
	public void update(MemberType memberType){
		String sql="update memberType set memberType_name=?,memberType_number=?,memberType_desc=?,memberType_benefit=? where memberType_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				memberType.getMemberType_name().trim(),
				memberType.getMemberType_number(),
				memberType.getMemberType_desc().trim(),
				memberType.getMemberType_benefit(),
				memberType.getMemberType_id()
		});
	}
	/**更改会员类型状态*/
	public void updateStatus(Integer memberType_id,Integer memberType_status){
		String sql="update memberType set memberType_status=? where memberType_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				memberType_status,
				memberType_id
		});
	}
	/**根据会员类型id获取会员类型*/
	public MemberType queryMemberTypeByMemberTypeId(Integer memberType_id){
		String sql="select * from memberType where memberType_id=?";
		Map<String,Object> map=DBUtil.query(sql,memberType_id);
		if(map!=null&&map.size()>0){
			MemberType memberType=new MemberType();
			try {
				BeanUtils.populate(memberType, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memberType;
		}else{
			return null;
		}
	}
}
