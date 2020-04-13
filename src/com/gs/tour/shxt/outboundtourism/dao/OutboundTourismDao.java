package com.gs.tour.shxt.outboundtourism.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.outboundtourism.model.OutboundTourism;

public class OutboundTourismDao {
	/**查找海外热门景点列表*/
	public PageBean getAllOutboundTourismList(PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		String sql="select * from outboundtourism where 1=1 limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<OutboundTourism> outboundTourismList=new ArrayList<OutboundTourism>();
			for (Map<String,Object> map : list) {
				OutboundTourism o=new OutboundTourism();
				try {
					BeanUtils.populate(o, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				outboundTourismList.add(o);
			}
			pageBean.setData(outboundTourismList);
			String countSql="select count(*) as num from outboundtourism ";
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
		String sql="update outboundtourism set outboundTourism_url=? where outboundTourism_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("outboundTourism_url").toString().trim(),
				map.get("outboundTourism_id").toString().trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public OutboundTourism load(Integer outboundTourism_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from outboundTourism where outboundTourism_id=?";
		Map<String,Object> map=DBUtil.query(sql, outboundTourism_id);
		OutboundTourism outboundTourism=new OutboundTourism();
		BeanUtils.populate(outboundTourism, map);
		return outboundTourism;
	}
	/**编辑热门景点信息*/
	public void update(OutboundTourism outboundTourism){
		String sql="update outboundtourism set outboundtourism_desc=? where outboundtourism_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				outboundTourism.getOutboundTourism_desc(),
				outboundTourism.getOutboundTourism_id()
		});
	}
}
