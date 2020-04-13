package com.gs.tour.shxt.user.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.user.model.User;

public class UserDao {
	/**登录验证*/
	public User login(String account,String password){
		String sql="select * from user where account=? and password=?";
		Map<String,Object> map=DBUtil.query(sql,new Object[]{account.trim(),password.trim()});
		if(map!=null&&map.size()>0){
			User user=new User();
			try {
				BeanUtils.populate(user, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}else{
			return null;
		}
	}
	/**查询员工列表*/
	public PageBean getAllUserList(User user,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from user where 1=1 ");
		if(user.getAccount()!=null&&user.getAccount().trim().length()>0){
			sb.append(" and account like '%"+StringEscapeUtils.escapeSql(user.getAccount())+"%'");
		}
		if(user.getUser_name()!=null&&user.getUser_name().trim().length()>0){
			sb.append(" and user_name like '%"+StringEscapeUtils.escapeSql(user.getUser_name())+"%'");
		}
		if(user.getUser_status()!=null){
			sb.append(" and user_status like '%"+StringEscapeUtils.escapeSql(user.getUser_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<User> userList=new ArrayList<User>();
			for (Map<String,Object> map : list) {
				User u=new User();
				try {
					BeanUtils.populate(u, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userList.add(u);
			}
			pageBean.setData(userList);
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
	/**验证账号是否重复*/
	public Integer checkAccount(String account){
		String sql="select count(1) as num from user where account=?";
		Integer num=Integer.parseInt(DBUtil.query(sql,account.trim()).get("num").toString());
		return num;
	}
	/**添加员工*/
	public Integer addUser(String account,String password,String user_name){
		String sql="insert into user (account,password,user_name) values(?,?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				account.trim(),
				password,
				user_name.trim()
		});
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public User load(Integer user_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from user where user_id=?";
		Map<String,Object> map=DBUtil.query(sql, user_id);
		User user=new User();
		BeanUtils.populate(user, map);
		return user;
	}
	/**编辑员工(小)*/
	public void update(User user){
		String sql="update user set user_name=? ,user_status=? where user_id=?";
		DBUtil.executeUpdate(sql,new Object[]{
				user.getUser_name(),
				user.getUser_status(),
				user.getUser_id()
		});
	}
	/**上传头像*/
	public Integer upload(Map<String,Object> map){
		String sql="update user set user_photo_url=? where user_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				map.get("user_photo_url").toString().trim(),
				map.get("user_id").toString().trim()
		});
	}
	/**根据用户ID查询详细信息*/
	public User queryUserByUserId(Integer user_id){
		String sql="select * from user where user_id=?";
		Map<String,Object> map=DBUtil.query(sql, user_id);
		if(map!=null&&map.size()>0){
			User u=new User();
			try {
				BeanUtils.populate(u, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return u;
		}else{
			return null;
		}
	}
	/**员工编辑（全）*/
	public Integer updateUserByUserId(User user){
		StringBuilder sb=new StringBuilder("update user set user_id="+user.getUser_id()+" ");
		if(user.getAccount()!=null&&user.getAccount().trim().length()>0){
			sb.append(" ,account='"+StringEscapeUtils.escapeSql(user.getAccount())+"'");
		}
		if(user.getPassword()!=null&&user.getPassword().trim().length()>0){
			sb.append(" ,password='"+StringEscapeUtils.escapeSql(user.getPassword())+"'");
		}
		if(user.getUser_name()!=null&&user.getUser_name().trim().length()>0){
			sb.append(" ,user_name='"+StringEscapeUtils.escapeSql(user.getUser_name())+"'");
		}
		if(user.getUser_code()!=null&&user.getUser_code().trim().length()>0){
			sb.append(" ,user_code='"+StringEscapeUtils.escapeSql(user.getUser_code())+"'");
		}
		if(user.getUser_tel()!=null&&user.getUser_tel().trim().length()>0){
			sb.append(" ,user_tel='"+StringEscapeUtils.escapeSql(user.getUser_tel())+"'");
		}
		if(user.getUser_sex()!=null&&user.getUser_sex().trim().length()>0){
			sb.append(" ,user_sex='"+StringEscapeUtils.escapeSql(user.getUser_sex())+"'");
		}
		if(user.getFk_role_id()!=null){
			sb.append(" ,fk_role_id='"+StringEscapeUtils.escapeSql(user.getFk_role_id().toString())+"'");
		}
		if(user.getFk_salary_id()!=null){
			sb.append(" ,fk_salary_id='"+StringEscapeUtils.escapeSql(user.getFk_salary_id().toString())+"'");
		}
		if(user.getUser_status()!=null){
			sb.append(" ,user_status='"+StringEscapeUtils.escapeSql(user.getUser_status().toString())+"'");
		}
		if(user.getFk_org_id()!=null){
			sb.append(" ,fk_org_id='"+StringEscapeUtils.escapeSql(user.getFk_org_id().toString())+"'");
		}
		if(user.getUser_photo_url()!=null&&user.getUser_photo_url().trim().length()>0){
			sb.append(" ,user_photo_url='"+StringEscapeUtils.escapeSql(user.getUser_photo_url())+"'");
		}
		if(user.getUser_email()!=null&&user.getUser_email().trim().length()>0){
			sb.append(" ,user_email='"+StringEscapeUtils.escapeSql(user.getUser_email())+"'");
		}
		String sql1="update user set fk_salary_id=? where user_id=?";
		DBUtil.executeUpdate(sql1, new Object[]{
				user.getFk_role_id(),
				user.getUser_id()
		});
		String sql=sb.toString()+" where user_id="+user.getUser_id();
		return DBUtil.executeUpdate(sql);
	}
	/**修改密码*/
	public void updatePassword(Integer user_id,String password) throws Exception{
		String sql="update user set password=? where user_id=?";
		DBUtil.executeUpdate(sql, new Object[]{password,user_id});
	}
	/**编辑个人信息*/
	public Integer updateMyselfInformation(User user){
		String sql="update user set fk_org_id=?,user_name=?,user_code=?,user_tel=?,user_sex=?,user_email=? where user_id=?";
		return DBUtil.executeUpdate(sql, new Object[]{
				user.getFk_org_id(),
				user.getUser_name().trim(),
				user.getUser_code().trim(),
				user.getUser_tel().trim(),
				user.getUser_sex().trim(),
				user.getUser_email(),
				user.getUser_id()
		});
	}
}
