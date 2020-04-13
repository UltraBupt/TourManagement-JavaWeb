package com.gs.tour.shxt.inboundticket.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.inboundticket.model.InboundTicket;

public class InboundTicketDao {
	/**查找门票列表*/
	public PageBean getAllInboundTicketList(PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		String sql="select * from inboundticket where 1=1 limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<InboundTicket> inboundTicketList=new ArrayList<InboundTicket>();
			for (Map<String,Object> map : list) {
				InboundTicket i=new InboundTicket();
				try {
					BeanUtils.populate(i, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				inboundTicketList.add(i);
			}
			pageBean.setData(inboundTicketList);
			String countSql="select count(*) as num from inboundticket ";
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
		String sql="update inboundticket set inboundTicket_url=? where inboundTicket_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("inboundTicket_url").toString().trim(),
				map.get("inboundTicket_id").toString().trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public InboundTicket load(Integer inboundTicket_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from inboundticket where inboundTicket_id=?";
		Map<String,Object> map=DBUtil.query(sql, inboundTicket_id);
		InboundTicket inboundTicket=new InboundTicket();
		BeanUtils.populate(inboundTicket, map);
		return inboundTicket;
	}
	/**编辑门票信息*/
	public void update(InboundTicket inboundTicket){
		String sql="update inboundticket set inboundTicket_desc=?,inboundTicket_price=? where inboundTicket_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				inboundTicket.getInboundTicket_desc().trim(),
				inboundTicket.getInboundTicket_price(),
				inboundTicket.getInboundTicket_id()
		});
	}
}
