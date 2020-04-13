package com.gs.tour.shxt.a.web.visa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.visa.model.Visa;

public class WebVisaDao {
	/**获取签证信息*/
	public List<Visa> getVisaList(){
		String sql="select * from visa where visa_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Visa> visaList=new ArrayList<Visa>();
			for (Map<String,Object> map : list) {
				Visa v=new Visa();
				try {
					BeanUtils.populate(v, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				visaList.add(v);
			}
			return visaList;
		}else{
			return null;
		}
	}
	/**根据签证id获取签证*/
	public Visa queryVisaByVisaId(Integer visa_id){
		String sql="select * from visa where visa_id=?";
		Map<String,Object> map=DBUtil.query(sql,visa_id);
		if(map!=null&&map.size()>0){
			Visa visa=new Visa();
			try {
				BeanUtils.populate(visa, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return visa;
		}else{
			return null;
		}
	}
}
