package com.gs.tour.shxt.a.web.bill.service;

import com.gs.tour.shxt.a.web.bill.dao.BillDao;
import com.gs.tour.shxt.a.web.bill.model.Bill;
import com.gs.tour.shxt.a.web.login.model.Member;

public class BillService {
	BillDao billDao=new BillDao();
	/**生成账单*/
	public void createBill(Bill bill ,Member member){
		this.billDao.createBill(bill, member);
	}
}
