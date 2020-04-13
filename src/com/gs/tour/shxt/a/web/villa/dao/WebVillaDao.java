package com.gs.tour.shxt.a.web.villa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.villa.model.Villa;

public class WebVillaDao {
	/**获取信息*/
	public List<Villa> getVillaList(){
		String sql="select * from villa where villa_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Villa> villaList=new ArrayList<Villa>();
			for (Map<String,Object> map : list) {
				Villa v=new Villa();
				try {
					BeanUtils.populate(v, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				villaList.add(v);
			}
			return villaList;
		}else{
			return null;
		}
	}
	/**根据别墅id获取别墅*/
	public Villa queryVillaByVillaId(Integer villa_id){
		String sql="select * from villa where villa_id=?";
		Map<String,Object> map=DBUtil.query(sql,villa_id);
		if(map!=null&&map.size()>0){
			Villa villa=new Villa();
			try {
				BeanUtils.populate(villa, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return villa;
		}else{
			return null;
		}
	}
}
