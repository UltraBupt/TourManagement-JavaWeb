package com.gs.tour.shxt.bill.service;

import com.gs.tour.shxt.a.web.bill.model.Bill;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.bill.dao.BillDao;

public class BillService {
	BillDao billDao=new BillDao();
	/**查询员工列表*/
	public PageBean getAllBillList(Bill bill,PageBean pageBean){
		return this.billDao.getAllBillList(bill, pageBean);
	}
	/**更新*/
	public Bill load(Integer bill_id){
		Bill bill;
		try {
			bill=this.billDao.load(bill_id);
			return bill;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑员工*/
	public void update(Bill bill){
		this.billDao.update(bill);
	}
}
