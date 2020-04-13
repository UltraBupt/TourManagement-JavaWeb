package com.gs.tour.shxt.outboundtourism.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.outboundtourism.dao.OutboundTourismDao;
import com.gs.tour.shxt.outboundtourism.model.OutboundTourism;

public class OutboundTourismService {
	OutboundTourismDao outboundTourismDao=new OutboundTourismDao();
	/**查找国内热门景点列表*/
	public PageBean getAllOutboundTourismList(PageBean pageBean){
		return this.outboundTourismDao.getAllOutboundTourismList(pageBean);
	}
	/**上传图片
	 * @throws Exception */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.outboundTourismDao.upload(map);
		if(num<=0){
			throw new Exception("上传图片失败");
		}
	}
	/**更新*/
	public OutboundTourism load(Integer outboundTourism_id){
		OutboundTourism outboundTourism;
		try {
			outboundTourism=this.outboundTourismDao.load(outboundTourism_id);
			return outboundTourism;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑热门景点信息*/
	public void update(OutboundTourism outboundTourism){
		this.outboundTourismDao.update(outboundTourism);
	}
}
