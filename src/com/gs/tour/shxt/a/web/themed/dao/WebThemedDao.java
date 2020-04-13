package com.gs.tour.shxt.a.web.themed.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.themed.model.Themed;

public class WebThemedDao {
	/**获取信息*/
	public List<Themed> getThemedList(){
		String sql="select * from themed where themed_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Themed> themedList=new ArrayList<Themed>();
			for (Map<String,Object> map : list) {
				Themed t=new Themed();
				try {
					BeanUtils.populate(t, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				themedList.add(t);
			}
			return themedList;
		}else{
			return null;
		}
	}
	/**根据主题id获取主题*/
	public Themed queryThemedByThemedId(Integer themed_id){
		String sql="select * from themed where themed_id=?";
		Map<String,Object> map=DBUtil.query(sql,themed_id);
		if(map!=null&&map.size()>0){
			Themed themed=new Themed();
			try {
				BeanUtils.populate(themed, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return themed;
		}else{
			return null;
		}
	}
}
