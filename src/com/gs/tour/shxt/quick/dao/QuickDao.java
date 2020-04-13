package com.gs.tour.shxt.quick.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.quick.model.Quick;

public class QuickDao {
	/**查询快餐列表*/
	public PageBean getAllQuickList(Quick quick,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from quick where 1=1 ");
		if(quick.getQuick_name()!=null&&quick.getQuick_name().trim().length()>0){
			sb.append(" and quick_name like '%"+StringEscapeUtils.escapeSql(quick.getQuick_name())+"%'");
		}
		if(quick.getQuick_status()!=null){
			sb.append(" and quick_status like '%"+StringEscapeUtils.escapeSql(quick.getQuick_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Quick> quickList=new ArrayList<Quick>();
			for (Map<String,Object> map : list) {
				Quick q=new Quick();
				try {
					BeanUtils.populate(q, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				quickList.add(q);
			}
			pageBean.setData(quickList);
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
	public Integer addQuick(Quick quick){
		String sql="insert into quick (quick_name,quick_price,quick_address,quick_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				quick.getQuick_name(),
				quick.getQuick_price(),
				quick.getQuick_address(),
				quick.getQuick_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Quick load(Integer quick_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from quick where quick_id=?";
		Map<String,Object> map=DBUtil.query(sql, quick_id);
		Quick quick=new Quick();
		BeanUtils.populate(quick, map);
		return quick;
	}
	/**编辑*/
	public void update(Quick quick){
		String sql="update quick set quick_name=? ,quick_price=?,quick_address=?,quick_desc=? where quick_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				quick.getQuick_name(),
				quick.getQuick_price(),
				quick.getQuick_address(),
				quick.getQuick_desc(),
				quick.getQuick_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update quick set quick_url=? where quick_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("quick_url").toString().trim(),
				map.get("quick_id").toString().trim()
		});
	}
	/**根据快餐id获取快餐*/
	public Quick queryQuickByQuickId(Integer quick_id){
		String sql="select * from quick where quick_id=?";
		Map<String,Object> map=DBUtil.query(sql,quick_id);
		if(map!=null&&map.size()>0){
			Quick quick=new Quick();
			try {
				BeanUtils.populate(quick, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return quick;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer quick_id,Integer quick_status) throws Exception{
		String sql="update quick set quick_status=? where quick_id=?";
		DBUtil.executeUpdate(sql, new Object[]{quick_status,quick_id});
	}
}
