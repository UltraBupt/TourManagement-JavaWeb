package com.gs.tour.shxt.faster.service;

import java.util.Map;

import com.gs.tour.shxt.faster.dao.FasterDao;
import com.gs.tour.shxt.faster.model.Faster;
import com.gs.tour.shxt.base.model.PageBean;

public class FasterService {
	FasterDao fasterDao=new FasterDao();
	/**查询动车票列表*/
	public PageBean getAllFasterList(Faster faster,PageBean pageBean){
		return this.fasterDao.getAllFasterList(faster, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addFaster(Faster faster) throws Exception{
		Integer num=this.fasterDao.addFaster(faster);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Faster load(Integer faster_id){
		Faster faster;
		try {
			faster=this.fasterDao.load(faster_id);
			return faster;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Faster faster){
		this.fasterDao.update(faster);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.fasterDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据动车票id获取动车票*/
	public Faster queryFasterByFasterId(Integer faster_id){
		return this.fasterDao.queryFasterByFasterId(faster_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer faster_id) throws Exception {
		Faster faster = this.fasterDao.queryFasterByFasterId(faster_id);
		Integer faster_status = faster.getFaster_status();
		if(faster_status==1){
			faster_status=0;
		}else{
			faster_status=1;
		}
		this.fasterDao.updateStatus(faster_id, faster_status);
		return faster_status;
	}
}
