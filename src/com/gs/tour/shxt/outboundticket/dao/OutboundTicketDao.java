package com.gs.tour.shxt.outboundticket.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.outboundticket.model.OutboundTicket;

public class OutboundTicketDao {
	/**查找门票列表*/
	public PageBean getAllOutboundTicketList(PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		String sql="select * from outboundticket where 1=1 limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<OutboundTicket> outboundTicketList=new ArrayList<OutboundTicket>();
			for (Map<String,Object> map : list) {
				OutboundTicket o=new OutboundTicket();
				try {
					BeanUtils.populate(o, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				outboundTicketList.add(o);
			}
			pageBean.setData(outboundTicketList);
			String countSql="select count(*) as num from outboundticket ";
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
		String sql="update outboundticket set outboundTicket_url=? where outboundTicket_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("outboundTicket_url").toString().trim(),
				map.get("outboundTicket_id").toString().trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public OutboundTicket load(Integer outboundTicket_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from outboundticket where outboundTicket_id=?";
		Map<String,Object> map=DBUtil.query(sql, outboundTicket_id);
		OutboundTicket outboundTicket=new OutboundTicket();
		BeanUtils.populate(outboundTicket, map);
		return outboundTicket;
	}
	/**编辑门票信息*/
	public void update(OutboundTicket outboundTicket){
		String sql="update outboundticket set outboundTicket_desc=?,outboundTicket_price=? where outboundTicket_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				outboundTicket.getOutboundTicket_desc().trim(),
				outboundTicket.getOutboundTicket_price(),
				outboundTicket.getOutboundTicket_id()
		});
	}
}
