package com.gs.tour.shxt.advertisement.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.advertisement.model.Advertisement;
import com.gs.tour.shxt.base.util.DBUtil;

public class AdvertisementDao {
	/**获取全部广告信息*/
	public List<Advertisement> getAllAdvertisementList(){
		String sql="select * from advertisement";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Advertisement> advertisementList=new ArrayList<Advertisement>();
			for (Map<String,Object> map : list) {
				Advertisement a=new Advertisement();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				advertisementList.add(a);
			}
			return advertisementList;
		}else{
			return null;
		}
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Advertisement load(Integer advertisement_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from advertisement where advertisement_id=?";
		Map<String,Object> map=DBUtil.query(sql,advertisement_id);
		Advertisement advertisement=new Advertisement();
		BeanUtils.populate(advertisement, map);
		return advertisement;
	}
	/**编辑广告*/
	public void update(Advertisement advertisement){
		String sql="update advertisement set advertisement_benefit=?,advertisement_desc=? where advertisement_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
			advertisement.getAdvertisement_benefit(),
			advertisement.getAdvertisement_desc(),
			advertisement.getAdvertisement_id()
		});
	}
	/**添加广告*/
	public Integer add(Advertisement advertisement){
		String sql="insert into advertisementBenefit (advertisementBenefit_benefit) values (?)";
		DBUtil.executeUpdate(sql, advertisement.getAdvertisement_benefit());
		String sql1="update advertisement set advertisement_benefit=?,advertisement_desc=? where advertisement_id=?";
		Integer num=DBUtil.executeUpdate(sql1, new Object[]{
				advertisement.getAdvertisement_benefit().trim(),
				advertisement.getAdvertisement_desc().trim(),
				advertisement.getAdvertisement_id()
		});
		return num;
	}
}
