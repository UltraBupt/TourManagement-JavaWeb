package com.gs.tour.shxt.buffet.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.a.web.buffet.model.Buffet;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class BuffetDao {
	/**查询自助列表*/
	public PageBean getAllBuffetList(Buffet buffet,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from buffet where 1=1 ");
		if(buffet.getBuffet_name()!=null&&buffet.getBuffet_name().trim().length()>0){
			sb.append(" and buffet_name like '%"+StringEscapeUtils.escapeSql(buffet.getBuffet_name())+"%'");
		}
		if(buffet.getBuffet_status()!=null){
			sb.append(" and buffet_status like '%"+StringEscapeUtils.escapeSql(buffet.getBuffet_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Buffet> buffetList=new ArrayList<Buffet>();
			for (Map<String,Object> map : list) {
				Buffet b=new Buffet();
				try {
					BeanUtils.populate(b, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				buffetList.add(b);
			}
			pageBean.setData(buffetList);
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
	public Integer addBuffet(Buffet buffet){
		String sql="insert into buffet (buffet_name,buffet_price,buffet_address,buffet_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				buffet.getBuffet_name(),
				buffet.getBuffet_price(),
				buffet.getBuffet_address(),
				buffet.getBuffet_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Buffet load(Integer buffet_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from buffet where buffet_id=?";
		Map<String,Object> map=DBUtil.query(sql, buffet_id);
		Buffet buffet=new Buffet();
		BeanUtils.populate(buffet, map);
		return buffet;
	}
	/**编辑*/
	public void update(Buffet buffet){
		String sql="update buffet set buffet_name=? ,buffet_price=?,buffet_address=?,buffet_desc=? where buffet_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				buffet.getBuffet_name(),
				buffet.getBuffet_price(),
				buffet.getBuffet_address(),
				buffet.getBuffet_desc(),
				buffet.getBuffet_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update buffet set buffet_url=? where buffet_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("buffet_url").toString().trim(),
				map.get("buffet_id").toString().trim()
		});
	}
	/**根据自助id获取自助*/
	public Buffet queryBuffetByBuffetId(Integer buffet_id){
		String sql="select * from buffet where buffet_id=?";
		Map<String,Object> map=DBUtil.query(sql,buffet_id);
		if(map!=null&&map.size()>0){
			Buffet buffet=new Buffet();
			try {
				BeanUtils.populate(buffet, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return buffet;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer buffet_id,Integer buffet_status) throws Exception{
		String sql="update buffet set buffet_status=? where buffet_id=?";
		DBUtil.executeUpdate(sql, new Object[]{buffet_status,buffet_id});
	}
}
