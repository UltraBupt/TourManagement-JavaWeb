package com.gs.tour.shxt.ship.service;

import java.util.Map;

import com.gs.tour.shxt.ship.dao.ShipDao;
import com.gs.tour.shxt.ship.model.Ship;
import com.gs.tour.shxt.base.model.PageBean;

public class ShipService {
	ShipDao shipDao=new ShipDao();
	/**查询轮船票列表*/
	public PageBean getAllShipList(Ship ship,PageBean pageBean){
		return this.shipDao.getAllShipList(ship, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addShip(Ship ship) throws Exception{
		Integer num=this.shipDao.addShip(ship);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Ship load(Integer ship_id){
		Ship ship;
		try {
			ship=this.shipDao.load(ship_id);
			return ship;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Ship ship){
		this.shipDao.update(ship);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.shipDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据轮船票id获取轮船票*/
	public Ship queryShipByShipId(Integer ship_id){
		return this.shipDao.queryShipByShipId(ship_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer ship_id) throws Exception {
		Ship ship = this.shipDao.queryShipByShipId(ship_id);
		Integer ship_status = ship.getShip_status();
		if(ship_status==1){
			ship_status=0;
		}else{
			ship_status=1;
		}
		this.shipDao.updateStatus(ship_id, ship_status);
		return ship_status;
	}
}
