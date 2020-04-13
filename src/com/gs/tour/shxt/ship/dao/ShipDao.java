package com.gs.tour.shxt.ship.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.ship.model.Ship;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class ShipDao {
	/**查询轮船票列表*/
	public PageBean getAllShipList(Ship ship,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from ship where 1=1 ");
		if(ship.getShip_point()!=null&&ship.getShip_point().trim().length()>0){
			sb.append(" and ship_point like '%"+StringEscapeUtils.escapeSql(ship.getShip_point())+"%'");
		}
		if(ship.getShip_status()!=null){
			sb.append(" and ship_status like '%"+StringEscapeUtils.escapeSql(ship.getShip_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
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
			pageBean.setData(shipList);
			String countSql="select count(*) as num from ("+sb.toString()+")t";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPage);
			return pageBean;
		}else{
			return null;
		}
	}
	/**添加*/
	public Integer addShip(Ship ship){
		String sql="insert into ship (ship_from,ship_to,ship_price,ship_time,ship_point) values(?,?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				ship.getShip_from(),
				ship.getShip_to(),
				ship.getShip_price(),
				ship.getShip_time(),
				ship.getShip_point()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Ship load(Integer ship_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from ship where ship_id=?";
		Map<String,Object> map=DBUtil.query(sql, ship_id);
		Ship ship=new Ship();
		BeanUtils.populate(ship, map);
		return ship;
	}
	/**编辑*/
	public void update(Ship ship){
		String sql="update ship set ship_from=? ,ship_to=?,ship_price=?,ship_time=?,ship_point=? where ship_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				ship.getShip_from(),
				ship.getShip_to(),
				ship.getShip_price(),
				ship.getShip_time(),
				ship.getShip_point(),
				ship.getShip_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update ship set ship_url=? where ship_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("ship_url").toString().trim(),
				map.get("ship_id").toString().trim()
		});
	}
	/**根据机票id获取机票*/
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
	/**更改状态*/
	public void updateStatus(Integer ship_id,Integer ship_status) throws Exception{
		String sql="update ship set ship_status=? where ship_id=?";
		DBUtil.executeUpdate(sql, new Object[]{ship_status,ship_id});
	}
}
