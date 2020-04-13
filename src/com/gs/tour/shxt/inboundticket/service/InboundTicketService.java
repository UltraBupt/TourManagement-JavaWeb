package com.gs.tour.shxt.inboundticket.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.inboundticket.dao.InboundTicketDao;
import com.gs.tour.shxt.inboundticket.model.InboundTicket;

public class InboundTicketService {
	InboundTicketDao inboundTicketDao=new InboundTicketDao();
	/**查找门票列表*/
	public PageBean getAllInboundTicketList(PageBean pageBean){
		return this.inboundTicketDao.getAllInboundTicketList(pageBean);
	}
	/**上传图片
	 * @throws Exception */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.inboundTicketDao.upload(map);
		if(num<=0){
			throw new Exception("上传图片失败");
		}
	}
	/**更新*/
	public InboundTicket load(Integer inboundTicket_id){
		InboundTicket inboundTicket;
		try {
			inboundTicket=this.inboundTicketDao.load(inboundTicket_id);
			return inboundTicket;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑门票信息*/
	public void update(InboundTicket inboundTicket){
		this.inboundTicketDao.update(inboundTicket);
	}
}
