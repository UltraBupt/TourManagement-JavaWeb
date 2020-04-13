package com.gs.tour.shxt.login_record.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.login_record.model.LoginRecord;

public class LoginRecordDao {
	/**查询登陆日志*/
	public PageBean getAllLoginRecoerdList(LoginRecord loginRecord,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from login_record where 1=1 ");
		if(loginRecord.getLogin_record_name()!=null&&loginRecord.getLogin_record_name().trim().length()>0){
			sb.append(" and login_record_name like '%"+StringEscapeUtils.escapeSql(loginRecord.getLogin_record_name())+"%'");
		}
		if(loginRecord.getLogin_record_account()!=null&&loginRecord.getLogin_record_account().trim().length()>0){
			sb.append(" and login_record_account like '%"+StringEscapeUtils.escapeSql(loginRecord.getLogin_record_account())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<LoginRecord> loginRecordList=new ArrayList<LoginRecord>();
			for (Map<String,Object> map : list) {
				LoginRecord l=new LoginRecord();
				try {
					BeanUtils.populate(l, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				loginRecordList.add(l);
			}
			pageBean.setData(loginRecordList);
			String countSql=" select count(*) as num from ("+sb.toString()+")t";
			Integer totalCount=Integer.parseInt(DBUtil.query(countSql).get("num").toString());
			pageBean.setTotalCount(totalCount);
			Integer totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			pageBean.setTotalPages(totalPage);
			return pageBean;
		}else{
			return null;
		}
	}
}
