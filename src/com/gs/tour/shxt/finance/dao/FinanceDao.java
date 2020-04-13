package com.gs.tour.shxt.finance.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.finance.model.Finance;

public class FinanceDao {
	/**查询金融列表*/
	public PageBean getAllFinanceList(Finance finance,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from finance where 1=1 ");
		if(finance.getFinance_name()!=null&&finance.getFinance_name().trim().length()>0){
			sb.append(" and finance_name like '%"+StringEscapeUtils.escapeSql(finance.getFinance_name())+"%'");
		}
		if(finance.getFinance_status()!=null){
			sb.append(" and finance_status like '%"+StringEscapeUtils.escapeSql(finance.getFinance_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Finance> financeList=new ArrayList<Finance>();
			for (Map<String,Object> map : list) {
				Finance f=new Finance();
				try {
					BeanUtils.populate(f, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				financeList.add(f);
			}
			pageBean.setData(financeList);
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
	/**添加*/
	public Integer addFinance(Finance finance){
		String sql="insert into finance (finance_name,finance_price,finance_number,finance_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				finance.getFinance_name(),
				finance.getFinance_price(),
				finance.getFinance_number(),
				finance.getFinance_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Finance load(Integer finance_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from finance where finance_id=?";
		Map<String,Object> map=DBUtil.query(sql, finance_id);
		Finance finance=new Finance();
		BeanUtils.populate(finance, map);
		return finance;
	}
	/**编辑*/
	public void update(Finance finance){
		String sql="update finance set finance_name=? ,finance_price=?,finance_number=?,finance_desc=? where finance_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				finance.getFinance_name(),
				finance.getFinance_price(),
				finance.getFinance_number(),
				finance.getFinance_desc(),
				finance.getFinance_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update finance set finance_url=? where finance_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("finance_url").toString().trim(),
				map.get("finance_id").toString().trim()
		});
	}
	/**根据金融id获取金融*/
	public Finance queryFinanceByFinanceId(Integer finance_id){
		String sql="select * from finance where finance_id=?";
		Map<String,Object> map=DBUtil.query(sql,finance_id);
		if(map!=null&&map.size()>0){
			Finance finance=new Finance();
			try {
				BeanUtils.populate(finance, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return finance;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer finance_id,Integer finance_status) throws Exception{
		String sql="update finance set finance_status=? where finance_id=?";
		DBUtil.executeUpdate(sql, new Object[]{finance_status,finance_id});
	}
}
