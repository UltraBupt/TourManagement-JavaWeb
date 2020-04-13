package com.gs.tour.shxt.outboundticket.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.outboundticket.dao.OutboundTicketDao;
import com.gs.tour.shxt.outboundticket.model.OutboundTicket;

public class OutboundTicketService {
	OutboundTicketDao outboundTicketDao=new OutboundTicketDao();
	/**查找门票列表*/
	public PageBean getAllOutboundTicketList(PageBean pageBean){
		return this.outboundTicketDao.getAllOutboundTicketList(pageBean);
	}
	/**上传图片
	 * @throws Exception */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.outboundTicketDao.upload(map);
		if(num<=0){
			throw new Exception("上传图片失败");
		}
	}
	/**更新*/
	public OutboundTicket load(Integer outboundTicket_id){
		OutboundTicket outboundTicket;
		try {
			outboundTicket=this.outboundTicketDao.load(outboundTicket_id);
			return outboundTicket;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑门票信息*/
	public void update(OutboundTicket outboundTicket){
		this.outboundTicketDao.update(outboundTicket);
	}
}
