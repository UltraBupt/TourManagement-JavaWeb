package com.gs.tour.shxt.visa.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.visa.model.Visa;

public class VisaDao {
	/**查询签证列表*/
	public PageBean getAllVisaList(Visa visa,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from visa where 1=1 ");
		if(visa.getVisa_address()!=null&&visa.getVisa_address().trim().length()>0){
			sb.append(" and visa_address like '%"+StringEscapeUtils.escapeSql(visa.getVisa_address())+"%'");
		}
		if(visa.getVisa_status()!=null){
			sb.append(" and visa_status like '%"+StringEscapeUtils.escapeSql(visa.getVisa_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Visa> visaList=new ArrayList<Visa>();
			for (Map<String,Object> map : list) {
				Visa v=new Visa();
				try {
					BeanUtils.populate(v, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				visaList.add(v);
			}
			pageBean.setData(visaList);
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
	/**添加签证*/
	public Integer addVisa(Visa visa){
		String sql="insert into visa (visa_address,visa_date,visa_price,visa_number,visa_day,visa_useful) values(?,?,?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				visa.getVisa_address(),
				visa.getVisa_date(),
				visa.getVisa_price(),
				visa.getVisa_number(),
				visa.getVisa_day(),
				visa.getVisa_useful()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Visa load(Integer visa_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from visa where visa_id=?";
		Map<String,Object> map=DBUtil.query(sql, visa_id);
		Visa visa=new Visa();
		BeanUtils.populate(visa, map);
		return visa;
	}
	/**编辑签证*/
	public void update(Visa visa){
		String sql="update visa set visa_address=? ,visa_date=?,visa_price=?,visa_number=?,visa_day=?,visa_useful=? where visa_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				visa.getVisa_address(),
				visa.getVisa_date(),
				visa.getVisa_price(),
				visa.getVisa_number(),
				visa.getVisa_day(),
				visa.getVisa_useful(),
				visa.getVisa_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update visa set visa_url=? where visa_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("visa_url").toString().trim(),
				map.get("visa_id").toString().trim()
		});
	}
	/**根据保险id获取签证*/
	public Visa queryVisaByVisaId(Integer visa_id){
		String sql="select * from visa where visa_id=?";
		Map<String,Object> map=DBUtil.query(sql,visa_id);
		if(map!=null&&map.size()>0){
			Visa v=new Visa();
			try {
				BeanUtils.populate(v, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return v;
		}else{
			return null;
		}
	}
	/**更改签证状态*/
	public void updateStatus(Integer visa_id,Integer visa_status) throws Exception{
		String sql="update visa set visa_status=? where visa_id=?";
		DBUtil.executeUpdate(sql, new Object[]{visa_status,visa_id});
	}
}
