package com.gs.tour.shxt.a.web.quick.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.quick.model.Quick;

public class WebQuickDao {
	/**获取信息*/
	public List<Quick> getQuickList(){
		String sql="select * from quick where quick_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Quick> quickList=new ArrayList<Quick>();
			for (Map<String,Object> map : list) {
				Quick q=new Quick();
				try {
					BeanUtils.populate(q, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				quickList.add(q);
			}
			return quickList;
		}else{
			return null;
		}
	}
	/**根据快餐id获取快餐*/
	public Quick queryQuickByQuickId(Integer quick_id){
		String sql="select * from quick where quick_id=?";
		Map<String,Object> map=DBUtil.query(sql,quick_id);
		if(map!=null&&map.size()>0){
			Quick quick=new Quick();
			try {
				BeanUtils.populate(quick, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return quick;
		}else{
			return null;
		}
	}
}
