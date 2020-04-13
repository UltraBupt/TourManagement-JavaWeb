package com.gs.tour.shxt.western.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.western.dao.WesternDao;
import com.gs.tour.shxt.western.model.Western;

public class WesternService {
	WesternDao westernDao=new WesternDao();
	/**查询西式列表*/
	public PageBean getAllWesternList(Western western,PageBean pageBean){
		return this.westernDao.getAllWesternList(western, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addWestern(Western western) throws Exception{
		Integer num=this.westernDao.addWestern(western);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Western load(Integer western_id){
		Western western;
		try {
			western=this.westernDao.load(western_id);
			return western;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Western western){
		this.westernDao.update(western);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.westernDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据西式id获取西式*/
	public Western queryWesternByWesternId(Integer western_id){
		return this.westernDao.queryWesternByWesternId(western_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer western_id) throws Exception {
		Western western = this.westernDao.queryWesternByWesternId(western_id);
		Integer western_status = western.getWestern_status();
		if(western_status==1){
			western_status=0;
		}else{
			western_status=1;
		}
		this.westernDao.updateStatus(western_id, western_status);
		return western_status;
	}
}
