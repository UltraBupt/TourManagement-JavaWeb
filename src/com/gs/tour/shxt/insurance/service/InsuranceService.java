package com.gs.tour.shxt.insurance.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.insurance.dao.InsuranceDao;
import com.gs.tour.shxt.insurance.model.Insurance;

public class InsuranceService {
	InsuranceDao insuranceDao=new InsuranceDao();
	/**查询保险列表*/
	public PageBean getAllInsuranceList(Insurance insurance,PageBean pageBean){
		return this.insuranceDao.getAllInsuranceList(insurance, pageBean);
	}
	/**添加账单
	 * @throws Exception */
	public void addInsurance(Insurance insurance) throws Exception{
		Integer num=this.insuranceDao.addInsurance(insurance);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Insurance load(Integer insurance_id){
		Insurance insurance;
		try {
			insurance=this.insuranceDao.load(insurance_id);
			return insurance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑员工*/
	public void update(Insurance insurance){
		this.insuranceDao.update(insurance);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.insuranceDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据保单id获取保单*/
	public Insurance queryInsuranceByInsuranceId(Integer insurance_id){
		return this.insuranceDao.queryInsuranceByInsuranceId(insurance_id);
	}
	/**更改保单状态*/
	public Integer updateStatus(Integer insurance_id) throws Exception {
		Insurance insurance = this.insuranceDao.queryInsuranceByInsuranceId(insurance_id);
		Integer insurance_status = insurance.getInsurance_status();
		if(insurance_status==1){
			insurance_status=0;
		}else{
			insurance_status=1;
		}
		this.insuranceDao.updateStatus(insurance_id, insurance_status);
		return insurance_status;
	}
}
