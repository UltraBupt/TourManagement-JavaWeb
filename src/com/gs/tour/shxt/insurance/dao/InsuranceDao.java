package com.gs.tour.shxt.insurance.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.insurance.model.Insurance;

public class InsuranceDao {
	/**查询保险列表*/
	public PageBean getAllInsuranceList(Insurance insurance,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from insurance where 1=1 ");
		if(insurance.getInsurance_name()!=null&&insurance.getInsurance_name().trim().length()>0){
			sb.append(" and insurance_name like '%"+StringEscapeUtils.escapeSql(insurance.getInsurance_name())+"%'");
		}
		if(insurance.getInsurance_status()!=null){
			sb.append(" and insurance_status like '%"+StringEscapeUtils.escapeSql(insurance.getInsurance_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Insurance> insuranceList=new ArrayList<Insurance>();
			for (Map<String,Object> map : list) {
				Insurance i=new Insurance();
				try {
					BeanUtils.populate(i, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				insuranceList.add(i);
			}
			pageBean.setData(insuranceList);
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
	/**添加账单*/
	public Integer addInsurance(Insurance insurance){
		String sql="insert into insurance (insurance_price,insurance_name,insurance_maxPrice,insurance_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				insurance.getInsurance_price(),
				insurance.getInsurance_name(),
				insurance.getInsurance_maxPrice(),
				insurance.getInsurance_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Insurance load(Integer insurance_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from insurance where insurance_id=?";
		Map<String,Object> map=DBUtil.query(sql, insurance_id);
		Insurance insurance=new Insurance();
		BeanUtils.populate(insurance, map);
		return insurance;
	}
	/**编辑保单*/
	public void update(Insurance insurance){
		String sql="update insurance set insurance_price=? ,insurance_name=?,insurance_maxPrice=?,insurance_desc=? where insurance_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				insurance.getInsurance_price(),
				insurance.getInsurance_name(),
				insurance.getInsurance_maxPrice(),
				insurance.getInsurance_desc(),
				insurance.getInsurance_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update insurance set insurance_url=? where insurance_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("insurance_url").toString().trim(),
				map.get("insurance_id").toString().trim()
		});
	}
	/**根据保险id获取保险*/
	public Insurance queryInsuranceByInsuranceId(Integer insurance_id){
		String sql="select * from insurance where insurance_id=?";
		Map<String,Object> map=DBUtil.query(sql,insurance_id);
		if(map!=null&&map.size()>0){
			Insurance insurance=new Insurance();
			try {
				BeanUtils.populate(insurance, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return insurance;
		}else{
			return null;
		}
	}
	/**更改保单状态*/
	public void updateStatus(Integer insurance_id,Integer insurance_status) throws Exception{
		String sql="update insurance set insurance_status=? where insurance_id=?";
		DBUtil.executeUpdate(sql, new Object[]{insurance_status,insurance_id});
	}
}
