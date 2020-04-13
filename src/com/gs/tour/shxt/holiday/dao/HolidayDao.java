package com.gs.tour.shxt.holiday.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.holiday.model.Holiday;

public class HolidayDao {
	/**查询假日酒店列表*/
	public PageBean getAllHolidayList(Holiday holiday,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from holiday where 1=1 ");
		if(holiday.getHoliday_name()!=null&&holiday.getHoliday_name().trim().length()>0){
			sb.append(" and holiday_name like '%"+StringEscapeUtils.escapeSql(holiday.getHoliday_name())+"%'");
		}
		if(holiday.getHoliday_status()!=null){
			sb.append(" and holiday_status like '%"+StringEscapeUtils.escapeSql(holiday.getHoliday_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
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
			pageBean.setData(holidayList);
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
	public Integer addHoliday(Holiday holiday){
		String sql="insert into holiday (holiday_name,holiday_price,holiday_address,holiday_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				holiday.getHoliday_name(),
				holiday.getHoliday_price(),
				holiday.getHoliday_address(),
				holiday.getHoliday_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Holiday load(Integer holiday_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from holiday where holiday_id=?";
		Map<String,Object> map=DBUtil.query(sql, holiday_id);
		Holiday holiday=new Holiday();
		BeanUtils.populate(holiday, map);
		return holiday;
	}
	/**编辑*/
	public void update(Holiday holiday){
		String sql="update holiday set holiday_name=? ,holiday_price=?,holiday_address=?,holiday_desc=? where holiday_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				holiday.getHoliday_name(),
				holiday.getHoliday_price(),
				holiday.getHoliday_address(),
				holiday.getHoliday_desc(),
				holiday.getHoliday_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update holiday set holiday_url=? where holiday_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("holiday_url").toString().trim(),
				map.get("holiday_id").toString().trim()
		});
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
	/**更改状态*/
	public void updateStatus(Integer holiday_id,Integer holiday_status) throws Exception{
		String sql="update holiday set holiday_status=? where holiday_id=?";
		DBUtil.executeUpdate(sql, new Object[]{holiday_status,holiday_id});
	}
}
