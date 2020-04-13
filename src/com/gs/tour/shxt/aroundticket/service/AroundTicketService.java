package com.gs.tour.shxt.aroundticket.service;
import java.util.Map;
import com.gs.tour.shxt.a.web.tour.model.AroundTicket;
import com.gs.tour.shxt.aroundticket.dao.AroundTicketDao;
import com.gs.tour.shxt.base.model.PageBean;

public class AroundTicketService {
	AroundTicketDao aroundTicketDao=new AroundTicketDao();
	/**查找周围热门景点列表*/
	public PageBean getAllAroundTicketList(PageBean pageBean){
		return this.aroundTicketDao.getAllAroundTicketList(pageBean); 
	}
	/**上传图片
	 * @throws Exception */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.aroundTicketDao.upload(map);
		if(num<=0){
			throw new Exception("上传图片失败");
		}
	}
	/**更新*/
	public AroundTicket load(Integer aroundTicket_id){
		AroundTicket aroundTicket;
		try {
			aroundTicket=this.aroundTicketDao.load(aroundTicket_id);
			return aroundTicket;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑热门景点信息*/
	public void update(AroundTicket aroundTicket){
		this.aroundTicketDao.update(aroundTicket);
	}
}
