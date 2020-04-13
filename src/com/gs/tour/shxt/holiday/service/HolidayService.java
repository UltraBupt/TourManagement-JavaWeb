package com.gs.tour.shxt.holiday.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.holiday.dao.HolidayDao;
import com.gs.tour.shxt.holiday.model.Holiday;

public class HolidayService {
	HolidayDao holidayDao=new HolidayDao();
	/**查询假日酒店列表*/
	public PageBean getAllHolidayList(Holiday holiday,PageBean pageBean){
		return this.holidayDao.getAllHolidayList(holiday, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addHoliday(Holiday holiday) throws Exception{
		Integer num=this.holidayDao.addHoliday(holiday);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Holiday load(Integer holiday_id){
		Holiday holiday;
		try {
			holiday=this.holidayDao.load(holiday_id);
			return holiday;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Holiday holiday){
		this.holidayDao.update(holiday);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.holidayDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据假日酒店id获取假日酒店*/
	public Holiday queryHolidayByHolidayId(Integer holiday_id){
		return this.holidayDao.queryHolidayByHolidayId(holiday_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer holiday_id) throws Exception {
		Holiday holiday = this.holidayDao.queryHolidayByHolidayId(holiday_id);
		Integer holiday_status = holiday.getHoliday_status();
		if(holiday_status==1){
			holiday_status=0;
		}else{
			holiday_status=1;
		}
		this.holidayDao.updateStatus(holiday_id, holiday_status);
		return holiday_status;
	}
}
