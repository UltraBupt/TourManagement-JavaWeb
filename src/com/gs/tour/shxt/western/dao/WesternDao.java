package com.gs.tour.shxt.western.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.western.model.Western;

public class WesternDao {
	/**查询西式列表*/
	public PageBean getAllWesternList(Western western,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from western where 1=1 ");
		if(western.getWestern_name()!=null&&western.getWestern_name().trim().length()>0){
			sb.append(" and western_name like '%"+StringEscapeUtils.escapeSql(western.getWestern_name())+"%'");
		}
		if(western.getWestern_status()!=null){
			sb.append(" and western_status like '%"+StringEscapeUtils.escapeSql(western.getWestern_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Western> westernList=new ArrayList<Western>();
			for (Map<String,Object> map : list) {
				Western w=new Western();
				try {
					BeanUtils.populate(w, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				westernList.add(w);
			}
			pageBean.setData(westernList);
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
	public Integer addWestern(Western western){
		String sql="insert into western (western_name,western_price,western_address,western_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				western.getWestern_name(),
				western.getWestern_price(),
				western.getWestern_address(),
				western.getWestern_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Western load(Integer western_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from western where western_id=?";
		Map<String,Object> map=DBUtil.query(sql, western_id);
		Western western=new Western();
		BeanUtils.populate(western, map);
		return western;
	}
	/**编辑*/
	public void update(Western western){
		String sql="update western set western_name=? ,western_price=?,western_address=?,western_desc=? where western_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				western.getWestern_name(),
				western.getWestern_price(),
				western.getWestern_address(),
				western.getWestern_desc(),
				western.getWestern_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update western set western_url=? where western_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("western_url").toString().trim(),
				map.get("western_id").toString().trim()
		});
	}
	/**根据西式id获取西式*/
	public Western queryWesternByWesternId(Integer western_id){
		String sql="select * from western where western_id=?";
		Map<String,Object> map=DBUtil.query(sql,western_id);
		if(map!=null&&map.size()>0){
			Western western=new Western();
			try {
				BeanUtils.populate(western, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return western;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer western_id,Integer western_status) throws Exception{
		String sql="update western set western_status=? where western_id=?";
		DBUtil.executeUpdate(sql, new Object[]{western_status,western_id});
	}
}
