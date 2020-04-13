package com.gs.tour.shxt.bill.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.a.web.bill.model.Bill;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class BillDao {
	/**查询员工列表*/
	public PageBean getAllBillList(Bill bill,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from bill where 1=1 ");
		if(bill.getBill_type()!=null&&bill.getBill_type().trim().length()>0){
			sb.append(" and bill_type like '%"+StringEscapeUtils.escapeSql(bill.getBill_type())+"%'");
		}
		if(bill.getBill_status()!=null){
			sb.append(" and bill_status like '%"+StringEscapeUtils.escapeSql(bill.getBill_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Bill> billList=new ArrayList<Bill>();
			for (Map<String,Object> map : list) {
				Bill b=new Bill();
				try {
					BeanUtils.populate(b, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				billList.add(b);
			}
			pageBean.setData(billList);
			String countSql="select count(*) as num from ("+sb.toString()+")t";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPage);
			return pageBean;
		}else{
			return null;
		}
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Bill load(Integer bill_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from bill where bill_id=?";
		Map<String,Object> map=DBUtil.query(sql, bill_id);
		Bill bill=new Bill();
		BeanUtils.populate(bill, map);
		return bill;
	}
	/**编辑*/
	public void update(Bill bill){
		String sql="update bill set bill_status=?  where bill_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				bill.getBill_status(),
				bill.getBill_id()
		});
	}
}
