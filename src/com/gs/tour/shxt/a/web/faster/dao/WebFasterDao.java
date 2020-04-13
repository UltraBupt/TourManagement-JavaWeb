package com.gs.tour.shxt.a.web.faster.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.faster.model.Faster;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebFasterDao {
	/**获取信息*/
	public List<Faster> getFasterList(){
		String sql="select * from faster where faster_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Faster> fasterList=new ArrayList<Faster>();
			for (Map<String,Object> map : list) {
				Faster a=new Faster();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				fasterList.add(a);
			}
			return fasterList;
		}else{
			return null;
		}
	}
	/**根据动车票id获取动车票*/
	public Faster queryFasterByFasterId(Integer faster_id){
		String sql="select * from faster where faster_id=?";
		Map<String,Object> map=DBUtil.query(sql,faster_id);
		if(map!=null&&map.size()>0){
			Faster faster=new Faster();
			try {
				BeanUtils.populate(faster, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return faster;
		}else{
			return null;
		}
	}
}
