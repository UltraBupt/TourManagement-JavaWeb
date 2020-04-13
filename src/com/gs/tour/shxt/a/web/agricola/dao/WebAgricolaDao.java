package com.gs.tour.shxt.a.web.agricola.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.agricola.model.Agricola;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebAgricolaDao {
	/**获取信息*/
	public List<Agricola> getAgricolaList(){
		String sql="select * from agricola where agricola_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Agricola> agricolaList=new ArrayList<Agricola>();
			for (Map<String,Object> map : list) {
				Agricola a=new Agricola();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				agricolaList.add(a);
			}
			return agricolaList;
		}else{
			return null;
		}
	}
	/**根据农家乐id获取农家乐*/
	public Agricola queryAgricolaByAgricolaId(Integer agricola_id){
		String sql="select * from agricola where agricola_id=?";
		Map<String,Object> map=DBUtil.query(sql,agricola_id);
		if(map!=null&&map.size()>0){
			Agricola agricola=new Agricola();
			try {
				BeanUtils.populate(agricola, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return agricola;
		}else{
			return null;
		}
	}
}
