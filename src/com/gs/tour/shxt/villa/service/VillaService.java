package com.gs.tour.shxt.villa.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.villa.dao.VillaDao;
import com.gs.tour.shxt.villa.model.Villa;

public class VillaService {
	VillaDao villaDao=new VillaDao();
	/**查询别墅列表*/
	public PageBean getAllVillaList(Villa villa,PageBean pageBean){
		return this.villaDao.getAllVillaList(villa, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addVilla(Villa villa) throws Exception{
		Integer num=this.villaDao.addVilla(villa);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Villa load(Integer villa_id){
		Villa villa;
		try {
			villa=this.villaDao.load(villa_id);
			return villa;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Villa villa){
		this.villaDao.update(villa);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.villaDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据别墅id获取别墅*/
	public Villa queryVillaByVillaId(Integer villa_id){
		return this.villaDao.queryVillaByVillaId(villa_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer villa_id) throws Exception {
		Villa villa = this.villaDao.queryVillaByVillaId(villa_id);
		Integer villa_status = villa.getVilla_status();
		if(villa_status==1){
			villa_status=0;
		}else{
			villa_status=1;
		}
		this.villaDao.updateStatus(villa_id, villa_status);
		return villa_status;
	}
}
