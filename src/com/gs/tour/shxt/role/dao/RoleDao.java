package com.gs.tour.shxt.role.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.role.model.Role;

public class RoleDao {
	/**查询全部可用角色*/
	public List<Role> getRoleList(){
		String sql="select * from role where role_status=1";
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Role> roleList=new ArrayList<Role>();
			for (Map<String,Object> map : list) {
				Role r=new Role();
				try {
					BeanUtils.populate(r, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				roleList.add(r);
			}
			return roleList;
		}else{
			return null;
		}
	}
	/**查询角色列表*/
	public PageBean getAllRoleList(Role role,PageBean pageBean){
		Integer pageNow=pageBean.getPageNow();
		Integer pageSize=pageBean.getPageSize();
		StringBuilder sb=new StringBuilder("select * from role where 1=1 ");
		if(role.getRole_name()!=null&&role.getRole_name().trim().length()>0){
			sb.append(" and role_name like '%"+StringEscapeUtils.escapeSql(role.getRole_name())+"%'");
		}
		if(role.getRole_status()!=null){
			sb.append(" and role_status like '%"+StringEscapeUtils.escapeSql(role.getRole_status().toString())+"%'");
		}
		String sql=sb.toString()+" limit "+pageSize*(pageNow-1)+","+pageSize;
		List<Map<String,Object>> list=DBUtil.list(sql);
		if(list!=null&&list.size()>0){
			List<Role> roleList=new ArrayList<Role>();
			for (Map<String,Object> map : list) {
				Role r=new Role();
				try {
					BeanUtils.populate(r, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				roleList.add(r);
			}
			pageBean.setData(roleList);
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
	/**添加角色*/
	public Integer addRole(String role_name,String role_desc){
		String sql="insert into role (role_name,role_desc) values (?,?)";
		return DBUtil.executeUpdate(sql, new Object[]{
				role_name.trim(),
				role_desc
		});
	}
	/**验证角色名是否重复*/
	public Integer checkRoleName(String role_name){
		String sql="select count(1) as num from role where role_name=?";
		return Integer.parseInt(DBUtil.query(sql, role_name).get("num").toString());
	}
	/**根据角色id获取角色*/
	public Role queryRoleByRoleId(Integer role_id){
		String sql="select * from role where role_id=?";
		Map<String,Object> map=DBUtil.query(sql,role_id);
		if(map!=null&&map.size()>0){
			Role role=new Role();
			try {
				BeanUtils.populate(role, map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return role;
		}else{
			return null;
		}
	}
	/**编辑角色*/
	public Integer updateRole(String role_name,String role_desc,Integer role_id){
		String sql="update role set role_name=?,role_desc=? where role_id=?";
		return DBUtil.executeUpdate(sql,new Object[]{
				role_name.trim(),
				role_desc,
				role_id
		});
	}
	/**更改角色状态*/
	public void updateStatus(Integer role_id,Integer role_status) throws Exception{
		String sql="update role set role_status=? where role_id=?";
		DBUtil.executeUpdate(sql, new Object[]{role_status,role_id});
	}
	/**分配权限--删除*/
	public Integer deleteMenuByRoleId(Integer role_id){
		String sql="delete from role_link_menu where fk_role_id=?";
		return DBUtil.executeUpdate(sql, role_id);
	}
	/**分配权限--添加*/
	public void distributeMenuByRoleId(Integer role_id,String[]menus){
		for (int i = 0; i < menus.length; i++) {
			String sql="insert into role_link_menu (fk_role_id,fk_menu_id) values(?,?)";
			DBUtil.executeUpdate(sql, new Object[]{
					role_id,
					menus[i]
			});
		}
	}
}
