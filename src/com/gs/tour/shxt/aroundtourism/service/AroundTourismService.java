package com.gs.tour.shxt.aroundtourism.service;

import java.util.Map;

import com.gs.tour.shxt.aroundtourism.dao.AroundTourismDao;
import com.gs.tour.shxt.aroundtourism.model.AroundTourism;
import com.gs.tour.shxt.base.model.PageBean;

public class AroundTourismService {
	AroundTourismDao aroundTourismDao=new AroundTourismDao();
	/**查找周围热门景点列表*/
	public PageBean getAllAroundTourismList(PageBean pageBean){
		return this.aroundTourismDao.getAllAroundTourismList(pageBean); 
	}
	/**上传图片
	 * @throws Exception */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.aroundTourismDao.upload(map);
		if(num<=0){
			throw new Exception("上传图片失败");
		}
	}
	/**更新*/
	public AroundTourism load(Integer aroundTourism_id){
		AroundTourism aroundTourism;
		try {
			aroundTourism=this.aroundTourismDao.load(aroundTourism_id);
			return aroundTourism;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑热门景点信息*/
	public void update(AroundTourism aroundTourism){
		this.aroundTourismDao.update(aroundTourism);
	}
}
