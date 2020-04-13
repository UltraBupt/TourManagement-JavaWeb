package com.gs.tour.shxt.snack.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.snack.dao.SnackDao;
import com.gs.tour.shxt.snack.model.Snack;

public class SnackService {
	SnackDao snackDao=new SnackDao();
	/**查询小吃列表*/
	public PageBean getAllSnackList(Snack snack,PageBean pageBean){
		return this.snackDao.getAllSnackList(snack, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addSnack(Snack snack) throws Exception{
		Integer num=this.snackDao.addSnack(snack);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Snack load(Integer snack_id){
		Snack snack;
		try {
			snack=this.snackDao.load(snack_id);
			return snack;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Snack snack){
		this.snackDao.update(snack);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.snackDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据小吃id获取小吃*/
	public Snack querySnackBySnackId(Integer snack_id){
		return this.snackDao.querySnackBySnackId(snack_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer snack_id) throws Exception {
		Snack snack = this.snackDao.querySnackBySnackId(snack_id);
		Integer snack_status = snack.getSnack_status();
		if(snack_status==1){
			snack_status=0;
		}else{
			snack_status=1;
		}
		this.snackDao.updateStatus(snack_id, snack_status);
		return snack_status;
	}
}
