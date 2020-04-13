package com.gs.tour.shxt.a.web.finance.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.finance.model.Finance;

public class WebFinanceDao {
	/**获取信息*/
	public List<Finance> getFinanceList(){
		String sql="select * from finance where finance_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Finance> financeList=new ArrayList<Finance>();
			for (Map<String,Object> map : list) {
				Finance f=new Finance();
				try {
					BeanUtils.populate(f, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				financeList.add(f);
			}
			return financeList;
		}else{
			return null;
		}
	}
	/**根据金融id获取金融*/
	public Finance queryFinanceByFinanceId(Integer finance_id){
		String sql="select * from finance where finance_id=?";
		Map<String,Object> map=DBUtil.query(sql,finance_id);
		if(map!=null&&map.size()>0){
			Finance finance=new Finance();
			try {
				BeanUtils.populate(finance, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return finance;
		}else{
			return null;
		}
	}
}
