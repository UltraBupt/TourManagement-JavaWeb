package com.gs.tour.shxt.a.web.holiday.service;

import java.util.List;

import com.gs.tour.shxt.a.web.holiday.dao.WebHolidayDao;
import com.gs.tour.shxt.holiday.model.Holiday;

public class WebHolidayService {
	WebHolidayDao webHolidayDao=new WebHolidayDao();
	/**获取信息*/
	public List<Holiday> getHolidayList(){
		return this.webHolidayDao.getHolidayList();
	}
	/**根据假日酒店id获取假日酒店*/
	public Holiday queryHolidayByHolidayId(Integer holiday_id){
		return this.webHolidayDao.queryHolidayByHolidayId(holiday_id);
	}
}
