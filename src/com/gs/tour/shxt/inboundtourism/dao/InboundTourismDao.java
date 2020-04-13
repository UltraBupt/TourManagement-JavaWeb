package com.gs.tour.shxt.inboundtourism.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.inboundtourism.model.InboundTourism;

public class InboundTourismDao {
	/**查找国内热门景点列表*/
	public PageBean getAllInboundTourismList(PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		String sql="select * from inboundtourism where 1=1 limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<InboundTourism> inboundTourismList=new ArrayList<InboundTourism>();
			for (Map<String,Object> map : list) {
				InboundTourism i=new InboundTourism();
				try {
					BeanUtils.populate(i, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				inboundTourismList.add(i);
			}
			pageBean.setData(inboundTourismList);
			String countSql="select count(*) as num from inboundtourism ";
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
		String sql="update inboundtourism set inboundTourism_url=? where inboundTourism_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("inboundTourism_url").toString().trim(),
				map.get("inboundTourism_id").toString().trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public InboundTourism load(Integer inboundTourism_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from inboundTourism where inboundTourism_id=?";
		Map<String,Object> map=DBUtil.query(sql, inboundTourism_id);
		InboundTourism inboundTourism=new InboundTourism();
		BeanUtils.populate(inboundTourism, map);
		return inboundTourism;
	}
	/**编辑热门景点信息*/
	public void update(InboundTourism inboundTourism){
		String sql="update inboundtourism set inboundtourism_desc=? where inboundtourism_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				inboundTourism.getInboundTourism_desc(),
				inboundTourism.getInboundTourism_id()
		});
	}
}
