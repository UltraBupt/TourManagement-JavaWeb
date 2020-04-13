package com.gs.tour.shxt.a.web.insurance.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.insurance.model.Insurance;

public class WebInsuranceDao {
	/**获取保险信息*/
	public List<Insurance> getInsuranceList(){
		String sql="select * from insurance where insurance_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Insurance> insuranceList=new ArrayList<Insurance>();
			for (Map<String,Object> map : list) {
				Insurance i=new Insurance();
				try {
					BeanUtils.populate(i, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				insuranceList.add(i);
			}
			return insuranceList;
		}else{
			return null;
		}
	}
	/**根据保险id获取保险*/
	public Insurance queryInsuranceByInsuranceId(Integer insurance_id){
		String sql="select * from insurance where insurance_id=?";
		Map<String,Object> map=DBUtil.query(sql,insurance_id);
		if(map!=null&&map.size()>0){
			Insurance insurance=new Insurance();
			try {
				BeanUtils.populate(insurance, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return insurance;
		}else{
			return null;
		}
	}
}
