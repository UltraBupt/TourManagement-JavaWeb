package com.gs.tour.shxt.a.web.themed.service;

import java.util.List;

import com.gs.tour.shxt.a.web.themed.dao.WebThemedDao;
import com.gs.tour.shxt.themed.model.Themed;

public class WebThemedService {
	WebThemedDao webThemedDao=new WebThemedDao();
	/**获取信息*/
	public List<Themed> getThemedList(){
		return this.webThemedDao.getThemedList();
	}
	/**根据主题id获取主题*/
	public Themed queryThemedByThemedId(Integer themed_id){
		return this.webThemedDao.queryThemedByThemedId(themed_id);
	}
}
