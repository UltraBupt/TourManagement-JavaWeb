package com.gs.tour.shxt.a.web.snack.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.snack.model.Snack;

public class WebSnackDao {
	/**获取信息*/
	public List<Snack> getSnackList(){
		String sql="select * from snack where snack_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Snack> snackList=new ArrayList<Snack>();
			for (Map<String,Object> map : list) {
				Snack s=new Snack();
				try {
					BeanUtils.populate(s, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				snackList.add(s);
			}
			return snackList;
		}else{
			return null;
		}
	}
	/**根据小吃id获取小吃*/
	public Snack querySnackBySnackId(Integer snack_id){
		String sql="select * from snack where snack_id=?";
		Map<String,Object> map=DBUtil.query(sql,snack_id);
		if(map!=null&&map.size()>0){
			Snack snack=new Snack();
			try {
				BeanUtils.populate(snack, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return snack;
		}else{
			return null;
		}
	}
}
