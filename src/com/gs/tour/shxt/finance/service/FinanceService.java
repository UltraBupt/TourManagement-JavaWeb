package com.gs.tour.shxt.finance.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.finance.dao.FinanceDao;
import com.gs.tour.shxt.finance.model.Finance;

public class FinanceService {
	FinanceDao financeDao=new FinanceDao();
	/**查询保险列表*/
	public PageBean getAllFinanceList(Finance finance,PageBean pageBean){
		return this.financeDao.getAllFinanceList(finance, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addFinance(Finance finance) throws Exception{
		Integer num=this.financeDao.addFinance(finance);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Finance load(Integer finance_id){
		Finance finance;
		try {
			finance=this.financeDao.load(finance_id);
			return finance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Finance finance){
		this.financeDao.update(finance);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.financeDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据金融id获取金融*/
	public Finance queryFinanceByFinanceId(Integer finance_id){
		return this.financeDao.queryFinanceByFinanceId(finance_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer finance_id) throws Exception {
		Finance finance = this.financeDao.queryFinanceByFinanceId(finance_id);
		Integer finance_status = finance.getFinance_status();
		if(finance_status==1){
			finance_status=0;
		}else{
			finance_status=1;
		}
		this.financeDao.updateStatus(finance_id, finance_status);
		return finance_status;
	}
}
