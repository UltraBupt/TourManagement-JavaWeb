package com.gs.tour.shxt.a.web.holiday.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.holiday.model.Holiday;

public class WebHolidayDao {
	/**获取信息*/
	public List<Holiday> getHolidayList(){
		String sql="select * from holiday where holiday_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Holiday> holidayList=new ArrayList<Holiday>();
			for (Map<String,Object> map : list) {
				Holiday h=new Holiday();
				try {
					BeanUtils.populate(h, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				holidayList.add(h);
			}
			return holidayList;
		}else{
			return null;
		}
	}
	/**根据假日酒店id获取假日酒店*/
	public Holiday queryHolidayByHolidayId(Integer holiday_id){
		String sql="select * from holiday where holiday_id=?";
		Map<String,Object> map=DBUtil.query(sql,holiday_id);
		if(map!=null&&map.size()>0){
			Holiday holiday=new Holiday();
			try {
				BeanUtils.populate(holiday, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return holiday;
		}else{
			return null;
		}
	}
}
