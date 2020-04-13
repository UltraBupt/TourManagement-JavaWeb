package com.gs.tour.shxt.agricola.service;

import java.util.Map;

import com.gs.tour.shxt.agricola.dao.AgricolaDao;
import com.gs.tour.shxt.agricola.model.Agricola;
import com.gs.tour.shxt.base.model.PageBean;

public class AgricolaService {
	AgricolaDao agricolaDao=new AgricolaDao();
	/**查询农家乐列表*/
	public PageBean getAllAgricolaList(Agricola agricola,PageBean pageBean){
		return this.agricolaDao.getAllAgricolaList(agricola, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addAgricola(Agricola agricola) throws Exception{
		Integer num=this.agricolaDao.addAgricola(agricola);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Agricola load(Integer agricola_id){
		Agricola agricola;
		try {
			agricola=this.agricolaDao.load(agricola_id);
			return agricola;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Agricola agricola){
		this.agricolaDao.update(agricola);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.agricolaDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据农家乐id获取农家乐*/
	public Agricola queryAgricolaByAgricolaId(Integer agricola_id){
		return this.agricolaDao.queryAgricolaByAgricolaId(agricola_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer agricola_id) throws Exception {
		Agricola agricola = this.agricolaDao.queryAgricolaByAgricolaId(agricola_id);
		Integer agricola_status = agricola.getAgricola_status();
		if(agricola_status==1){
			agricola_status=0;
		}else{
			agricola_status=1;
		}
		this.agricolaDao.updateStatus(agricola_id, agricola_status);
		return agricola_status;
	}
}
