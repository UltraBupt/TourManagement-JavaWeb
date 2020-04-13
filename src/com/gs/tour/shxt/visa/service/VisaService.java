package com.gs.tour.shxt.visa.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.visa.dao.VisaDao;
import com.gs.tour.shxt.visa.model.Visa;

public class VisaService {
	VisaDao visaDao=new VisaDao();
	/**查询签证列表*/
	public PageBean getAllVisaList(Visa visa,PageBean pageBean){
		return this.visaDao.getAllVisaList(visa, pageBean);
	}
	/**添加签证
	 * @throws Exception */
	public void addVisa(Visa visa) throws Exception{
		Integer num=this.visaDao.addVisa(visa);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Visa load(Integer visa_id){
		Visa visa;
		try {
			visa=this.visaDao.load(visa_id);
			return visa;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑签证*/
	public void update(Visa visa){
		this.visaDao.update(visa);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.visaDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据签证id获取签证*/
	public Visa queryVisaByVisaId(Integer visa_id){
		return this.visaDao.queryVisaByVisaId(visa_id);
	}
	/**更改签证状态*/
	public Integer updateStatus(Integer visa_id) throws Exception {
		Visa visa = this.visaDao.queryVisaByVisaId(visa_id);
		Integer visa_status = visa.getVisa_status();
		if(visa_status==1){
			visa_status=0;
		}else{
			visa_status=1;
		}
		this.visaDao.updateStatus(visa_id, visa_status);
		return visa_status;
	}
}
