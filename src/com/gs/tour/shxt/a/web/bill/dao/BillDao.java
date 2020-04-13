package com.gs.tour.shxt.a.web.bill.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gs.tour.shxt.a.web.bill.model.Bill;
import com.gs.tour.shxt.a.web.login.model.Member;
import com.gs.tour.shxt.base.util.DBUtil;

public class BillDao {
	/**生成账单*/
	public void createBill(Bill bill ,Member member){
		String bill_memberAccount=member.getMember_account();
		String member_benefit=member.getMember_benefit();
		Integer member_number=member.getMember_number();
		Date date=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String bill_createDate=s.format(date);
		member_number=member_number+1;
		String member_type="青铜";
		if(member_number<5){
			member_type="青铜";
			member_benefit="0.99";
		}else if(member_number<=10){
			member_type="白银";
			member_benefit="0.97";
		}else if(member_number<=15){
			member_type="黄金";
			member_benefit="0.95";
		}else{
			member_type="钻石";
			member_benefit="0.93";
		}
		double bill_totalPrice=(Double.parseDouble(bill.getBill_price())*Integer.parseInt(bill.getBill_number())*Double.parseDouble(member_benefit));
		String sql1="update member set member_number=?,member_type=?,member_benefit=? where member_id=?";
		DBUtil.executeUpdate(sql1, new Object[]{
				member_number,
				member_type,
				member_benefit,
				member.getMember_id()
		});
		String sql="insert into bill (bill_type,bill_code,bill_thing,bill_memberAccount,bill_memberPhone,bill_price,bill_number,bill_totalPrice,bill_createDate) values(?,?,?,?,?,?,?,?,?)";
		DBUtil.executeUpdate(sql, new Object[]{
			bill.getBill_type(),
			bill.getBill_code(),
			bill.getBill_thing(),
			bill_memberAccount,
			bill.getBill_memberPhone(),
			bill.getBill_price(),
			bill.getBill_number(),
			bill_totalPrice,
			bill_createDate
		});
	}
}
