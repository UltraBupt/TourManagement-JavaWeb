package com.gs.tour.shxt.a.web.train.service;

import java.util.List;

import com.gs.tour.shxt.a.web.train.dao.WebTrainDao;
import com.gs.tour.shxt.train.model.Train;

public class WebTrainService {
	WebTrainDao webTrainDao=new WebTrainDao();
	/**获取信息*/
	public List<Train> getTrainList(){
		return this.webTrainDao.getTrainList();
	}
	/**根据火车票id获取火车票*/
	public Train queryTrainByTrainId(Integer train_id){
		return this.webTrainDao.queryTrainByTrainId(train_id);
	}
}
