package com.gs.tour.shxt.train.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.train.model.Train;

public class TrainDao {
	/**查询火车票列表*/
	public PageBean getAllTrainList(Train train,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from train where 1=1 ");
		if(train.getTrain_point()!=null&&train.getTrain_point().trim().length()>0){
			sb.append(" and train_point like '%"+StringEscapeUtils.escapeSql(train.getTrain_point())+"%'");
		}
		if(train.getTrain_status()!=null){
			sb.append(" and train_status like '%"+StringEscapeUtils.escapeSql(train.getTrain_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Train> trainList=new ArrayList<Train>();
			for (Map<String,Object> map : list) {
				Train t=new Train();
				try {
					BeanUtils.populate(t, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				trainList.add(t);
			}
			pageBean.setData(trainList);
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
	public Integer addTrain(Train train){
		String sql="insert into train (train_from,train_to,train_price,train_time,train_point) values(?,?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				train.getTrain_from(),
				train.getTrain_to(),
				train.getTrain_price(),
				train.getTrain_time(),
				train.getTrain_point()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Train load(Integer train_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from train where train_id=?";
		Map<String,Object> map=DBUtil.query(sql, train_id);
		Train train=new Train();
		BeanUtils.populate(train, map);
		return train;
	}
	/**编辑*/
	public void update(Train train){
		String sql="update train set train_from=? ,train_to=?,train_price=?,train_time=?,train_point=? where train_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				train.getTrain_from(),
				train.getTrain_to(),
				train.getTrain_price(),
				train.getTrain_time(),
				train.getTrain_point(),
				train.getTrain_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update train set train_url=? where train_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("train_url").toString().trim(),
				map.get("train_id").toString().trim()
		});
	}
	/**根据火车票id获取火车票*/
	public Train queryTrainByTrainId(Integer train_id){
		String sql="select * from train where train_id=?";
		Map<String,Object> map=DBUtil.query(sql,train_id);
		if(map!=null&&map.size()>0){
			Train train=new Train();
			try {
				BeanUtils.populate(train, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return train;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer train_id,Integer train_status) throws Exception{
		String sql="update train set train_status=? where train_id=?";
		DBUtil.executeUpdate(sql, new Object[]{train_status,train_id});
	}
}
