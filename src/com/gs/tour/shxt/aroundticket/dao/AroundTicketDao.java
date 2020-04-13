package com.gs.tour.shxt.aroundticket.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.tour.model.AroundTicket;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class AroundTicketDao {
	/**查找门票列表*/
	public PageBean getAllAroundTicketList(PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		String sql="select * from aroundTicket where 1=1 limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<AroundTicket> aroundTicketList=new ArrayList<AroundTicket>();
			for (Map<String,Object> map : list) {
				AroundTicket a=new AroundTicket();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				aroundTicketList.add(a);
			}
			pageBean.setData(aroundTicketList);
			String countSql="select count(*) as num from aroundTicket ";
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
		String sql="update aroundTicket set aroundTicket_url=? where aroundTicket_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("aroundTicket_url").toString().trim(),
				map.get("aroundTicket_id").toString().trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public AroundTicket load(Integer aroundTicket_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from aroundTicket where aroundTicket_id=?";
		Map<String,Object> map=DBUtil.query(sql, aroundTicket_id);
		AroundTicket aroundTicket=new AroundTicket();
		BeanUtils.populate(aroundTicket, map);
		return aroundTicket;
	}
	/**编辑门票信息*/
	public void update(AroundTicket aroundTicket){
		String sql="update aroundTicket set aroundTicket_desc=?,aroundTicket_price=? where aroundTicket_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				aroundTicket.getAroundTicket_desc().trim(),
				aroundTicket.getAroundTicket_price(),
				aroundTicket.getAroundTicket_id()
		});
	}
}
