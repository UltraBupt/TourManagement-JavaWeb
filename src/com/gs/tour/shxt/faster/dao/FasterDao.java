package com.gs.tour.shxt.faster.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.faster.model.Faster;
import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;

public class FasterDao {
	/**查询动车票列表*/
	public PageBean getAllFasterList(Faster faster,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from faster where 1=1 ");
		if(faster.getFaster_point()!=null&&faster.getFaster_point().trim().length()>0){
			sb.append(" and faster_point like '%"+StringEscapeUtils.escapeSql(faster.getFaster_point())+"%'");
		}
		if(faster.getFaster_status()!=null){
			sb.append(" and faster_status like '%"+StringEscapeUtils.escapeSql(faster.getFaster_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Faster> fasterList=new ArrayList<Faster>();
			for (Map<String,Object> map : list) {
				Faster a=new Faster();
				try {
					BeanUtils.populate(a, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				fasterList.add(a);
			}
			pageBean.setData(fasterList);
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
	public Integer addFaster(Faster faster){
		String sql="insert into faster (faster_from,faster_to,faster_price,faster_time,faster_point) values(?,?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				faster.getFaster_from(),
				faster.getFaster_to(),
				faster.getFaster_price(),
				faster.getFaster_time(),
				faster.getFaster_point()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Faster load(Integer faster_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from faster where faster_id=?";
		Map<String,Object> map=DBUtil.query(sql, faster_id);
		Faster faster=new Faster();
		BeanUtils.populate(faster, map);
		return faster;
	}
	/**编辑*/
	public void update(Faster faster){
		String sql="update faster set faster_from=? ,faster_to=?,faster_price=?,faster_time=?,faster_point=? where faster_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				faster.getFaster_from(),
				faster.getFaster_to(),
				faster.getFaster_price(),
				faster.getFaster_time(),
				faster.getFaster_point(),
				faster.getFaster_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update faster set faster_url=? where faster_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("faster_url").toString().trim(),
				map.get("faster_id").toString().trim()
		});
	}
	/**根据动车票id获取动车票*/
	public Faster queryFasterByFasterId(Integer faster_id){
		String sql="select * from faster where faster_id=?";
		Map<String,Object> map=DBUtil.query(sql,faster_id);
		if(map!=null&&map.size()>0){
			Faster faster=new Faster();
			try {
				BeanUtils.populate(faster, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return faster;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer faster_id,Integer faster_status) throws Exception{
		String sql="update faster set faster_status=? where faster_id=?";
		DBUtil.executeUpdate(sql, new Object[]{faster_status,faster_id});
	}
}
