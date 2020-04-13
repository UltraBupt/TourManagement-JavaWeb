package com.gs.tour.shxt.villa.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.villa.model.Villa;

public class VillaDao {
	/**查询别墅列表*/
	public PageBean getAllVillaList(Villa villa,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from villa where 1=1 ");
		if(villa.getVilla_name()!=null&&villa.getVilla_name().trim().length()>0){
			sb.append(" and villa_name like '%"+StringEscapeUtils.escapeSql(villa.getVilla_name())+"%'");
		}
		if(villa.getVilla_status()!=null){
			sb.append(" and villa_status like '%"+StringEscapeUtils.escapeSql(villa.getVilla_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Villa> villaList=new ArrayList<Villa>();
			for (Map<String,Object> map : list) {
				Villa v=new Villa();
				try {
					BeanUtils.populate(v, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				villaList.add(v);
			}
			pageBean.setData(villaList);
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
	public Integer addVilla(Villa villa){
		String sql="insert into villa (villa_name,villa_price,villa_address,villa_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				villa.getVilla_name(),
				villa.getVilla_price(),
				villa.getVilla_address(),
				villa.getVilla_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Villa load(Integer villa_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from villa where villa_id=?";
		Map<String,Object> map=DBUtil.query(sql, villa_id);
		Villa villa=new Villa();
		BeanUtils.populate(villa, map);
		return villa;
	}
	/**编辑*/
	public void update(Villa villa){
		String sql="update villa set villa_name=? ,villa_price=?,villa_address=?,villa_desc=? where villa_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				villa.getVilla_name(),
				villa.getVilla_price(),
				villa.getVilla_address(),
				villa.getVilla_desc(),
				villa.getVilla_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update villa set villa_url=? where villa_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("villa_url").toString().trim(),
				map.get("villa_id").toString().trim()
		});
	}
	/**根据别墅id获取别墅*/
	public Villa queryVillaByVillaId(Integer villa_id){
		String sql="select * from villa where villa_id=?";
		Map<String,Object> map=DBUtil.query(sql,villa_id);
		if(map!=null&&map.size()>0){
			Villa villa=new Villa();
			try {
				BeanUtils.populate(villa, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return villa;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer villa_id,Integer villa_status) throws Exception{
		String sql="update villa set villa_status=? where villa_id=?";
		DBUtil.executeUpdate(sql, new Object[]{villa_status,villa_id});
	}
}
