package com.gs.tour.shxt.apartment.service;

import java.util.Map;

import com.gs.tour.shxt.apartment.dao.ApartmentDao;
import com.gs.tour.shxt.apartment.model.Apartment;
import com.gs.tour.shxt.base.model.PageBean;

public class ApartmentService {
	ApartmentDao apartmentDao=new ApartmentDao();
	/**查询公寓列表*/
	public PageBean getAllApartmentList(Apartment apartment,PageBean pageBean){
		return this.apartmentDao.getAllApartmentList(apartment, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addApartment(Apartment apartment) throws Exception{
		Integer num=this.apartmentDao.addApartment(apartment);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Apartment load(Integer apartment_id){
		Apartment apartment;
		try {
			apartment=this.apartmentDao.load(apartment_id);
			return apartment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Apartment apartment){
		this.apartmentDao.update(apartment);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.apartmentDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据公寓id获取公寓*/
	public Apartment queryApartmentByApartmentId(Integer apartment_id){
		return this.apartmentDao.queryApartmentByApartmentId(apartment_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer apartment_id) throws Exception {
		Apartment apartment = this.apartmentDao.queryApartmentByApartmentId(apartment_id);
		Integer apartment_status = apartment.getApartment_status();
		if(apartment_status==1){
			apartment_status=0;
		}else{
			apartment_status=1;
		}
		this.apartmentDao.updateStatus(apartment_id, apartment_status);
		return apartment_status;
	}
}
