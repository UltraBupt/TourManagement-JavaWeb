package com.gs.tour.shxt.agricola.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.agricola.model.Agricola;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class AgricolaDao {
	/**查询农家乐列表*/
	public PageBean getAllAgricolaList(Agricola agricola,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from agricola where 1=1 ");
		if(agricola.getAgricola_name()!=null&&agricola.getAgricola_name().trim().length()>0){
			sb.append(" and agricola_name like '%"+StringEscapeUtils.escapeSql(agricola.getAgricola_name())+"%'");
		}
		if(agricola.getAgricola_status()!=null){
			sb.append(" and agricola_status like '%"+StringEscapeUtils.escapeSql(agricola.getAgricola_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Agricola> agricolaList=new ArrayList<Agricola>();
			for (Map<String,Object> map : list) {
				Agricola a=new Agricola();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				agricolaList.add(a);
			}
			pageBean.setData(agricolaList);
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
	/**添加*/
	public Integer addAgricola(Agricola agricola){
		String sql="insert into agricola (agricola_name,agricola_price,agricola_address,agricola_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				agricola.getAgricola_name(),
				agricola.getAgricola_price(),
				agricola.getAgricola_address(),
				agricola.getAgricola_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Agricola load(Integer agricola_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from agricola where agricola_id=?";
		Map<String,Object> map=DBUtil.query(sql, agricola_id);
		Agricola agricola=new Agricola();
		BeanUtils.populate(agricola, map);
		return agricola;
	}
	/**编辑*/
	public void update(Agricola agricola){
		String sql="update agricola set agricola_name=? ,agricola_price=?,agricola_address=?,agricola_desc=? where agricola_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				agricola.getAgricola_name(),
				agricola.getAgricola_price(),
				agricola.getAgricola_address(),
				agricola.getAgricola_desc(),
				agricola.getAgricola_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update agricola set agricola_url=? where agricola_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("agricola_url").toString().trim(),
				map.get("agricola_id").toString().trim()
		});
	}
	/**根据农家乐id获取农家乐*/
	public Agricola queryAgricolaByAgricolaId(Integer agricola_id){
		String sql="select * from agricola where agricola_id=?";
		Map<String,Object> map=DBUtil.query(sql,agricola_id);
		if(map!=null&&map.size()>0){
			Agricola agricola=new Agricola();
			try {
				BeanUtils.populate(agricola, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return agricola;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer agricola_id,Integer agricola_status) throws Exception{
		String sql="update agricola set agricola_status=? where agricola_id=?";
		DBUtil.executeUpdate(sql, new Object[]{agricola_status,agricola_id});
	}
}
