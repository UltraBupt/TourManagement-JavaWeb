package com.gs.tour.shxt.a.web.train.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.train.model.Train;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebTrainDao {
	/**获取信息*/
	public List<Train> getTrainList(){
		String sql="select * from train where train_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Train> trainList=new ArrayList<Train>();
			for (Map<String,Object> map : list) {
				Train a=new Train();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				trainList.add(a);
			}
			return trainList;
		}else{
			return null;
		}
	}
	/**根据火车票id获取火车票*/
	public Train queryTrainByTrainId(Integer train_id){
		String sql="select * from train where train_id=?";
		Map<String,Object> map=DBUtil.query(sql,train_id);
		if(map!=null&&map.size()>0){
			Train train=new Train();
			try {
				BeanUtils.populate(train, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return train;
		}else{
			return null;
		}
	}
}
