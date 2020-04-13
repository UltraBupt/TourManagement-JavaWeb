package com.gs.tour.shxt.message.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.message.model.NewMessage;

public class NewMessageDao {
	/**查询留言列表*/
	public PageBean getAllNewMessageList(NewMessage newMessage,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from newmessage where 1=1 ");
		if(newMessage.getNewMessage_status()!=null){
			sb.append(" and newMessage_status like '%"+StringEscapeUtils.escapeSql(newMessage.getNewMessage_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<NewMessage> newMessageList=new ArrayList<NewMessage>();
			for (Map<String,Object> map : list) {
				NewMessage n=new NewMessage();
				try {
					BeanUtils.populate(n, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				newMessageList.add(n);
			}
			pageBean.setData(newMessageList);
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
	/**根据留言id获取留言*/
	public NewMessage queryNewMessageByNewMessageId(Integer newMessage_id){
		String sql="select * from newmessage where newMessage_id=?";
		Map<String,Object> map=DBUtil.query(sql,newMessage_id);
		if(map!=null&&map.size()>0){
			NewMessage newMessage=new NewMessage();
			try {
				BeanUtils.populate(newMessage, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return newMessage;
		}else{
			return null;
		}
	}
	/**变更留言状态*/
	public void updateStatus(Integer newMessage_id,Integer newMessage_status) throws Exception{
		String sql="update newmessage set newMessage_status=? where newMessage_id=?";
		DBUtil.executeUpdate(sql, new Object[]{newMessage_status,newMessage_id});
	}
}
