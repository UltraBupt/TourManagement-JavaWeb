package com.gs.tour.shxt.partnerType.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.partnerType.model.PartnerType;

public class PartnerTypeDao {
	/**查询合作商类型列表*/
	public PageBean getAllPartnerTypeList(PartnerType partnerType,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from partnerType where 1=1 ");
		if(partnerType.getPartnerType_name()!=null&&partnerType.getPartnerType_name().trim().length()>0){
			sb.append(" and partnerType_name like '%"+StringEscapeUtils.escapeSql(partnerType.getPartnerType_name())+"%'");
		}
		if(partnerType.getPartnerType_status()!=null){
			sb.append(" and partnerType_status like '%"+StringEscapeUtils.escapeSql(partnerType.getPartnerType_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<PartnerType> partnerTypelist=new ArrayList<PartnerType>();
			for (Map<String,Object> map : list) {
				PartnerType p=new PartnerType();
				try {
					BeanUtils.populate(p, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				partnerTypelist.add(p);
			}
			pageBean.setData(partnerTypelist);
			String countSql=" select count(*) as num from ("+sb.toString()+")t";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPage);
			return pageBean;
		}else{
			return null;
		}
	}
	/**验证合作商类型是否重复*/
	public Integer checkPartnerTypeName(String partnerType_name){
		String sql="select count(1) as num from partnerType where partnerType_name=?";
		Integer num=Integer.parseInt(DBUtil.query(sql, partnerType_name.trim()).get("num").toString());
		return num;
	}
	/**添加合作商类型*/
	public Integer addPartnerType(String partnerType_name,String partnerType_desc){
		String sql="insert into partnerType (partnerType_name,partnerType_desc) values(?,?)";
		return DBUtil.executeUpdate(sql,new Object[]{
				partnerType_name.trim(),
				partnerType_desc.trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public PartnerType load(Integer partnerType_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from partnerType where partnerType_id=?";
		Map<String,Object> map=DBUtil.query(sql, partnerType_id);
		PartnerType partnerType=new PartnerType();
		BeanUtils.populate(partnerType, map);
		return partnerType;
	}
	/**编辑供应商类别*/
	public void update(PartnerType partnerType){
		String sql="update partnerType set partnerType_name=?,partnerType_desc=? where partnerType_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				partnerType.getPartnerType_name().trim(),
				partnerType.getPartnerType_desc().trim(),
				partnerType.getPartnerType_id()
		});
	}
	/**根据供应商id获取供应商*/
	public PartnerType queryPartnerTypeByPartnerTypeId(Integer partnerType_id){
		String sql="select * from partnerType where partnerType_id=?";
		Map<String,Object> map=DBUtil.query(sql,partnerType_id);
		if(map!=null&&map.size()>0){
			PartnerType partnerType=new PartnerType();
			try {
				BeanUtils.populate(partnerType, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return partnerType;
		}else{
			return null;
		}
	}
	/**更改供应商类型状态*/
	public void updateStatus(Integer partnerType_id,Integer partnerType_status){
		String sql="update partnerType set partnerType_status=? where partnerType_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				partnerType_status,
				partnerType_id
		});
	}
	/**查询全部可用合作商类型*/
	public List<PartnerType> getAllPartnerType(){
		String sql="select * from partnerType where partnerType_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<PartnerType> partnerTypeList=new ArrayList<PartnerType>();
			for (Map<String,Object> map : list) {
				PartnerType p=new PartnerType();
				try {
					BeanUtils.populate(p, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				partnerTypeList.add(p);
			}
			return partnerTypeList;
		}else{
			return null;
		}
	}
}
