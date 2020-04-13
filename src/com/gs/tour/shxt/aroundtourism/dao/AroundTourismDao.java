package com.gs.tour.shxt.aroundtourism.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.aroundtourism.model.AroundTourism;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class AroundTourismDao {
	/**查找周围热门景点列表*/
	public PageBean getAllAroundTourismList(PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		String sql="select * from aroundTourism where 1=1 limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<AroundTourism> aroundTourismList=new ArrayList<AroundTourism>();
			for (Map<String,Object> map : list) {
				AroundTourism a=new AroundTourism();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				aroundTourismList.add(a);
			}
			pageBean.setData(aroundTourismList);
			String countSql="select count(*) as num from aroundTourism ";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPage);
			return pageBean;
		}else{
			return null;
		}
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update aroundTourism set aroundTourism_url=? where aroundTourism_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("aroundTourism_url").toString().trim(),
				map.get("aroundTourism_id").toString().trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public AroundTourism load(Integer aroundTourism_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from aroundTourism where aroundTourism_id=?";
		Map<String,Object> map=DBUtil.query(sql, aroundTourism_id);
		AroundTourism aroundTourism=new AroundTourism();
		BeanUtils.populate(aroundTourism, map);
		return aroundTourism;
	}
	/**编辑热门景点信息*/
	public void update(AroundTourism aroundTourism){
		String sql="update aroundTourism set aroundTourism_desc=? where aroundTourism_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				aroundTourism.getAroundTourism_desc(),
				aroundTourism.getAroundTourism_id()
		});
	}
}
