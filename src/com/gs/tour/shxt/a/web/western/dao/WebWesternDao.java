package com.gs.tour.shxt.a.web.western.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.western.model.Western;

public class WebWesternDao {
	/**获取信息*/
	public List<Western> getWesternList(){
		String sql="select * from western where western_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Western> westernList=new ArrayList<Western>();
			for (Map<String,Object> map : list) {
				Western w=new Western();
				try {
					BeanUtils.populate(w, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				westernList.add(w);
			}
			return westernList;
		}else{
			return null;
		}
	}
	/**根据西式id获取西式*/
	public Western queryWesternByWesternId(Integer western_id){
		String sql="select * from western where western_id=?";
		Map<String,Object> map=DBUtil.query(sql,western_id);
		if(map!=null&&map.size()>0){
			Western western=new Western();
			try {
				BeanUtils.populate(western, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return western;
		}else{
			return null;
		}
	}
}
