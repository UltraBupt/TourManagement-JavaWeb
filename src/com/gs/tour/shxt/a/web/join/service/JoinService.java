package com.gs.tour.shxt.a.web.join.service;

import java.util.List;

import com.gs.tour.shxt.a.web.join.dao.JoinDao;
import com.gs.tour.shxt.recruit.model.Recruit;

public class JoinService {
	JoinDao joinDao=new JoinDao();
	/**获取招聘信息*/
	public List<Recruit> getRecruit(){
		return this.joinDao.getRecruit();
	}
}
