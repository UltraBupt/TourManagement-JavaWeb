package com.gs.tour.shxt.bus.service;

import java.util.Map;

import com.gs.tour.shxt.bus.dao.BusDao;
import com.gs.tour.shxt.bus.model.Bus;
import com.gs.tour.shxt.base.model.PageBean;

public class BusService {
	BusDao busDao=new BusDao();
	/**查询汽车票列表*/
	public PageBean getAllBusList(Bus bus,PageBean pageBean){
		return this.busDao.getAllBusList(bus, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addBus(Bus bus) throws Exception{
		Integer num=this.busDao.addBus(bus);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Bus load(Integer bus_id){
		Bus bus;
		try {
			bus=this.busDao.load(bus_id);
			return bus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Bus bus){
		this.busDao.update(bus);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.busDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据汽车票id获取汽车票*/
	public Bus queryBusByBusId(Integer bus_id){
		return this.busDao.queryBusByBusId(bus_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer bus_id) throws Exception {
		Bus bus = this.busDao.queryBusByBusId(bus_id);
		Integer bus_status = bus.getBus_status();
		if(bus_status==1){
			bus_status=0;
		}else{
			bus_status=1;
		}
		this.busDao.updateStatus(bus_id, bus_status);
		return bus_status;
	}
}
