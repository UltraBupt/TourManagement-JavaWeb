package com.gs.tour.shxt.a.web.login.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.a.web.login.model.Member;
import com.gs.tour.shxt.base.util.DBUtil;

public class WebMemberDao {
	/**登录验证*/
	public Member login(String account,String password){
		String sql="select * from member where member_account=? and member_password=?";
		Map<String,Object> map=DBUtil.query(sql, new Object[]{account.trim(),password.trim()});
		if(map!=null&&map.size()>0){
			Member member=new Member();
			try {
				BeanUtils.populate(member, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return member;
		}else{
			return null;
		}
	}
	/**更新
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Member load(Integer member_id) throws IllegalAccessException, InvocationTargetException{
		String sql="select * from member where member_id=?";
		Map<String,Object> map=DBUtil.query(sql, member_id);
		Member member=new Member();
		BeanUtils.populate(member, map);
		return member;
	}
	/**修改密码*/
	public void updatePassword(Integer member_id,String password){
		String sql="update member set member_password=? where member_id=?";
		DBUtil.executeUpdate(sql, new Object[]{
				password,
				member_id
		});
	}
}
