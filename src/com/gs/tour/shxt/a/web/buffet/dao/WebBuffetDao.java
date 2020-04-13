package com.gs.tour.shxt.a.web.buffet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.buffet.model.Buffet;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebBuffetDao {
	/**获取信息*/
	public List<Buffet> getBuffetList(){
		String sql="select * from buffet where buffet_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Buffet> buffetList=new ArrayList<Buffet>();
			for (Map<String,Object> map : list) {
				Buffet b=new Buffet();
				try {
					BeanUtils.populate(b, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				buffetList.add(b);
			}
			return buffetList;
		}else{
			return null;
		}
	}
	/**根据小吃id获取小吃*/
	public Buffet queryBuffetByBuffetId(Integer buffet_id){
		String sql="select * from buffet where buffet_id=?";
		Map<String,Object> map=DBUtil.query(sql,buffet_id);
		if(map!=null&&map.size()>0){
			Buffet buffet=new Buffet();
			try {
				BeanUtils.populate(buffet, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return buffet;
		}else{
			return null;
		}
	}
}	
