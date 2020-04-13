package com.gs.tour.shxt.partner.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.partner.model.Partner;

public class PartnerDao {
	/**查询合作商列表*/
	public PageBean getAllPartnerList(Partner partner,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from partner where 1=1 ");
		if(partner.getPartner_type()!=null&&partner.getPartner_type().trim().length()>0){
			sb.append(" and partner_type like '%"+StringEscapeUtils.escapeSql(partner.getPartner_type())+"%'");
		}
		if(partner.getPartner_name()!=null&&partner.getPartner_name().trim().length()>0){
			sb.append(" and partner_name like '%"+StringEscapeUtils.escapeSql(partner.getPartner_name())+"%'");
		}
		if(partner.getPartner_status()!=null){
			sb.append(" and partner_status like '%"+StringEscapeUtils.escapeSql(partner.getPartner_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Partner> partnerList=new ArrayList<Partner>();
			for (Map<String,Object> map : list) {
				Partner p=new Partner();
				try {
					BeanUtils.populate(p, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				partnerList.add(p);
			}
			pageBean.setData(partnerList);
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
	/**添加合作商*/
	public Integer addPartner(Integer fk_partnerType_id,String partner_name,String partner_position,String partner_hobby,String partner_desc){
		String sql="select partnerType_name from partnerType where partnerType_id=?";
		String partner_type=DBUtil.query(sql,fk_partnerType_id).get("partnerType_name").toString();
		String sql1="insert into partner (partner_name,partner_position,partner_type,partner_hobby,partner_desc,fk_partnerType_id) values (?,?,?,?,?,?)";
		return DBUtil.executeUpdate(sql1,new Object[]{
				partner_name.trim(),
				partner_position.trim(),
				partner_type.trim(),
				partner_hobby.trim(),
				partner_desc.trim(),
				fk_partnerType_id
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Partner load(Integer partner_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from partner where partner_id=?";
		Map<String,Object> map=DBUtil.query(sql,partner_id);
		Partner partner=new Partner();
		BeanUtils.populate(partner, map);
		return partner;
	}
	/**编辑合作商*/
	public void update(Partner partner){
		String sql="select partnerType_name from partnerType where partnerType_id=?";
		String partner_type=DBUtil.query(sql, partner.getFk_partnerType_id()).get("partnerType_name").toString();
		String sql1="update partner set partner_name=?,partner_position=?,partner_type=?,partner_hobby=?,partner_desc=?,fk_partnerType_id=? where partner_id=?";
		DBUtil.executeUpdate(sql1,new Object[]{
				partner.getPartner_name().trim(),
				partner.getPartner_position().trim(),
				partner_type.trim(),
				partner.getPartner_hobby().trim(),
				partner.getPartner_desc().trim(),
				partner.getFk_partnerType_id(),
				partner.getPartner_id()
		});
	}
	/**根据合作商id获取合作商*/
	public Partner queryPartnerByPartnerId(Integer partner_id){
		String sql="select * from partner where partner_id=?";
		Map<String,Object> map=DBUtil.query(sql,partner_id);
		if(map!=null&&map.size()>0){
			Partner partner=new Partner();
			try {
				BeanUtils.populate(partner, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return partner;
		}else{
			return null;
		}
	}
	/**更改合作商状态*/
	public void updateStatus(Integer partner_id,Integer partner_status){
		String sql="update partner set partner_status=? where partner_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
			partner_status,
			partner_id
		});
	}
}
