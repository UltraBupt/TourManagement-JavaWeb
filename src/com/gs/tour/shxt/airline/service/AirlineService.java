package com.gs.tour.shxt.airline.service;

import java.util.Map;

import com.gs.tour.shxt.airline.dao.AirlineDao;
import com.gs.tour.shxt.airline.model.Airline;
import com.gs.tour.shxt.base.model.PageBean;

public class AirlineService {
	AirlineDao airlineDao=new AirlineDao();
	/**查询机票列表*/
	public PageBean getAllAirlineList(Airline airline,PageBean pageBean){
		return this.airlineDao.getAllAirlineList(airline, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addAirline(Airline airline) throws Exception{
		Integer num=this.airlineDao.addAirline(airline);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Airline load(Integer airline_id){
		Airline airline;
		try {
			airline=this.airlineDao.load(airline_id);
			return airline;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Airline airline){
		this.airlineDao.update(airline);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.airlineDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据机票id获取机票*/
	public Airline queryAirlineByAirlineId(Integer airline_id){
		return this.airlineDao.queryAirlineByAirlineId(airline_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer airline_id) throws Exception {
		Airline airline = this.airlineDao.queryAirlineByAirlineId(airline_id);
		Integer airline_status = airline.getAirline_status();
		if(airline_status==1){
			airline_status=0;
		}else{
			airline_status=1;
		}
		this.airlineDao.updateStatus(airline_id, airline_status);
		return airline_status;
	}
}
