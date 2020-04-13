package com.gs.tour.shxt.buffet.service;

import java.util.Map;

import com.gs.tour.shxt.a.web.buffet.model.Buffet;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.buffet.dao.BuffetDao;

public class BuffetService {
	BuffetDao buffetDao=new BuffetDao();
	/**查询自助列表*/
	public PageBean getAllBuffetList(Buffet buffet,PageBean pageBean){
		return this.buffetDao.getAllBuffetList(buffet, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addBuffet(Buffet buffet) throws Exception{
		Integer num=this.buffetDao.addBuffet(buffet);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Buffet load(Integer buffet_id){
		Buffet buffet;
		try {
			buffet=this.buffetDao.load(buffet_id);
			return buffet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Buffet buffet){
		this.buffetDao.update(buffet);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.buffetDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据自助id获取自助*/
	public Buffet queryBuffetByBuffetId(Integer buffet_id){
		return this.buffetDao.queryBuffetByBuffetId(buffet_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer buffet_id) throws Exception {
		Buffet buffet = this.buffetDao.queryBuffetByBuffetId(buffet_id);
		Integer buffet_status = buffet.getBuffet_status();
		if(buffet_status==1){
			buffet_status=0;
		}else{
			buffet_status=1;
		}
		this.buffetDao.updateStatus(buffet_id, buffet_status);
		return buffet_status;
	}
}
