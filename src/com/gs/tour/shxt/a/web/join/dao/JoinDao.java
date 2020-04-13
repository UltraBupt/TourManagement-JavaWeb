package com.gs.tour.shxt.a.web.join.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.recruit.model.Recruit;

public class JoinDao {
	/**获取招聘信息*/
	public List<Recruit> getRecruit(){
		String sql="select * from recruit where recruit_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Recruit> recruitList=new ArrayList<Recruit>();
			for (Map<String,Object> map : list) {
				Recruit r=new Recruit();
				try {
					BeanUtils.populate(r, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				recruitList.add(r);
			}
			return recruitList;
		}else{
			return null;
		}
	}
}
