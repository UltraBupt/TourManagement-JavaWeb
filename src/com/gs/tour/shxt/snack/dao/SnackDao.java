package com.gs.tour.shxt.snack.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.snack.model.Snack;

public class SnackDao {
	/**查询小吃列表*/
	public PageBean getAllSnackList(Snack snack,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from snack where 1=1 ");
		if(snack.getSnack_name()!=null&&snack.getSnack_name().trim().length()>0){
			sb.append(" and snack_name like '%"+StringEscapeUtils.escapeSql(snack.getSnack_name())+"%'");
		}
		if(snack.getSnack_status()!=null){
			sb.append(" and snack_status like '%"+StringEscapeUtils.escapeSql(snack.getSnack_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Snack> snackList=new ArrayList<Snack>();
			for (Map<String,Object> map : list) {
				Snack s=new Snack();
				try {
					BeanUtils.populate(s, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				snackList.add(s);
			}
			pageBean.setData(snackList);
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
	public Integer addSnack(Snack snack){
		String sql="insert into snack (snack_name,snack_price,snack_address,snack_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				snack.getSnack_name(),
				snack.getSnack_price(),
				snack.getSnack_address(),
				snack.getSnack_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Snack load(Integer snack_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from snack where snack_id=?";
		Map<String,Object> map=DBUtil.query(sql, snack_id);
		Snack snack=new Snack();
		BeanUtils.populate(snack, map);
		return snack;
	}
	/**编辑*/
	public void update(Snack snack){
		String sql="update snack set snack_name=? ,snack_price=?,snack_address=?,snack_desc=? where snack_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				snack.getSnack_name(),
				snack.getSnack_price(),
				snack.getSnack_address(),
				snack.getSnack_desc(),
				snack.getSnack_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update snack set snack_url=? where snack_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("snack_url").toString().trim(),
				map.get("snack_id").toString().trim()
		});
	}
	/**根据小吃id获取小吃*/
	public Snack querySnackBySnackId(Integer snack_id){
		String sql="select * from snack where snack_id=?";
		Map<String,Object> map=DBUtil.query(sql,snack_id);
		if(map!=null&&map.size()>0){
			Snack snack=new Snack();
			try {
				BeanUtils.populate(snack, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return snack;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer snack_id,Integer snack_status) throws Exception{
		String sql="update snack set snack_status=? where snack_id=?";
		DBUtil.executeUpdate(sql, new Object[]{snack_status,snack_id});
	}
}
