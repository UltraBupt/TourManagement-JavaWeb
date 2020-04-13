package com.gs.tour.shxt.inboundtourism.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.inboundtourism.dao.InboundTourismDao;
import com.gs.tour.shxt.inboundtourism.model.InboundTourism;

public class InboundTourismService {
	InboundTourismDao inboundTourismDao=new InboundTourismDao();
	/**查找国内热门景点列表*/
	public PageBean getAllInboundTourismList(PageBean pageBean){
		return this.inboundTourismDao.getAllInboundTourismList(pageBean);
	}
	/**上传图片
	 * @throws Exception */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.inboundTourismDao.upload(map);
		if(num<=0){
			throw new Exception("上传图片失败");
		}
	}
	/**更新*/
	public InboundTourism load(Integer inboundTourism_id){
		InboundTourism inboundTourism;
		try {
			inboundTourism=this.inboundTourismDao.load(inboundTourism_id);
			return inboundTourism;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑热门景点信息*/
	public void update(InboundTourism inboundTourism){
		this.inboundTourismDao.update(inboundTourism);
	}
}
