package com.gs.tour.shxt.a.web.ship.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.ship.model.Ship;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebShipDao {
	/**获取信息*/
	public List<Ship> getShipList(){
		String sql="select * from ship where ship_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Ship> shipList=new ArrayList<Ship>();
			for (Map<String,Object> map : list) {
				Ship a=new Ship();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				shipList.add(a);
			}
			return shipList;
		}else{
			return null;
		}
	}
	/**根据轮船票id获取轮船票*/
	public Ship queryShipByShipId(Integer ship_id){
		String sql="select * from ship where ship_id=?";
		Map<String,Object> map=DBUtil.query(sql,ship_id);
		if(map!=null&&map.size()>0){
			Ship ship=new Ship();
			try {
				BeanUtils.populate(ship, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ship;
		}else{
			return null;
		}
	}
}
