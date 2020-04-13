package com.gs.tour.shxt.quick.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.quick.dao.QuickDao;
import com.gs.tour.shxt.quick.model.Quick;

public class QuickService {
	QuickDao quickDao=new QuickDao();
	/**查询快餐列表*/
	public PageBean getAllQuickList(Quick quick,PageBean pageBean){
		return this.quickDao.getAllQuickList(quick, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addQuick(Quick quick) throws Exception{
		Integer num=this.quickDao.addQuick(quick);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Quick load(Integer quick_id){
		Quick quick;
		try {
			quick=this.quickDao.load(quick_id);
			return quick;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Quick quick){
		this.quickDao.update(quick);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.quickDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据快餐id获取快餐*/
	public Quick queryQuickByQuickId(Integer quick_id){
		return this.quickDao.queryQuickByQuickId(quick_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer quick_id) throws Exception {
		Quick quick = this.quickDao.queryQuickByQuickId(quick_id);
		Integer quick_status = quick.getQuick_status();
		if(quick_status==1){
			quick_status=0;
		}else{
			quick_status=1;
		}
		this.quickDao.updateStatus(quick_id, quick_status);
		return quick_status;
	}
}
