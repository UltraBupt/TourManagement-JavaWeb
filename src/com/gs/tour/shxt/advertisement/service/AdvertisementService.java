package com.gs.tour.shxt.advertisement.service;

import java.util.List;

import com.gs.tour.shxt.advertisement.dao.AdvertisementDao;
import com.gs.tour.shxt.advertisement.model.Advertisement;

public class AdvertisementService {
	AdvertisementDao advertisementDao=new AdvertisementDao();
	/**获取全部广告信息*/
	public List<Advertisement> getAllAdvertisementList(){
		return this.advertisementDao.getAllAdvertisementList();
	}
	/**更新*/
	public Advertisement load(Integer advertisement_id){
		Advertisement advertisement;
		try {
			advertisement=this.advertisementDao.load(advertisement_id);
			return advertisement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑广告*/
	public void update(Advertisement advertisement){
		this.advertisementDao.update(advertisement);
	}
	/**添加广告
	 * @throws Exception */
	public void add(Advertisement advertisement) throws Exception{
		Integer num=this.advertisementDao.add(advertisement);
		if(num<=0){
			throw new Exception("广告添加失败");
		}
	}
}
