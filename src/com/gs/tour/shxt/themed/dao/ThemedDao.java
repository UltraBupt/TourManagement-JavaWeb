package com.gs.tour.shxt.themed.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.themed.model.Themed;

public class ThemedDao {
	/**查询主题列表*/
	public PageBean getAllThemedList(Themed themed,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from themed where 1=1 ");
		if(themed.getThemed_name()!=null&&themed.getThemed_name().trim().length()>0){
			sb.append(" and themed_name like '%"+StringEscapeUtils.escapeSql(themed.getThemed_name())+"%'");
		}
		if(themed.getThemed_status()!=null){
			sb.append(" and themed_status like '%"+StringEscapeUtils.escapeSql(themed.getThemed_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Themed> themedList=new ArrayList<Themed>();
			for (Map<String,Object> map : list) {
				Themed t=new Themed();
				try {
					BeanUtils.populate(t, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				themedList.add(t);
			}
			pageBean.setData(themedList);
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
	public Integer addThemed(Themed themed){
		String sql="insert into themed (themed_name,themed_price,themed_address,themed_desc) values(?,?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				themed.getThemed_name(),
				themed.getThemed_price(),
				themed.getThemed_address(),
				themed.getThemed_desc()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Themed load(Integer themed_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from themed where themed_id=?";
		Map<String,Object> map=DBUtil.query(sql, themed_id);
		Themed themed=new Themed();
		BeanUtils.populate(themed, map);
		return themed;
	}
	/**编辑*/
	public void update(Themed themed){
		String sql="update themed set themed_name=? ,themed_price=?,themed_address=?,themed_desc=? where themed_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				themed.getThemed_name(),
				themed.getThemed_price(),
				themed.getThemed_address(),
				themed.getThemed_desc(),
				themed.getThemed_id()
		});
	}
	/**上传图片*/
	public Integer upload(Map<String,Object> map){
		String sql="update themed set themed_url=? where themed_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("themed_url").toString().trim(),
				map.get("themed_id").toString().trim()
		});
	}
	/**根据主题id获取主题*/
	public Themed queryThemedByThemedId(Integer themed_id){
		String sql="select * from themed where themed_id=?";
		Map<String,Object> map=DBUtil.query(sql,themed_id);
		if(map!=null&&map.size()>0){
			Themed themed=new Themed();
			try {
				BeanUtils.populate(themed, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return themed;
		}else{
			return null;
		}
	}
	/**更改状态*/
	public void updateStatus(Integer themed_id,Integer themed_status) throws Exception{
		String sql="update themed set themed_status=? where themed_id=?";
		DBUtil.executeUpdate(sql, new Object[]{themed_status,themed_id});
	}
}
