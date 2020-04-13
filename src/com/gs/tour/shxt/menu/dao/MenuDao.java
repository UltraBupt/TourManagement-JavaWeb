package com.gs.tour.shxt.menu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gs.tour.shxt.base.util.DBUtil;
import com.gs.tour.shxt.menu.model.Menu;

public class MenuDao {
	/**根据角色id查询该角色具有的父菜单的权限*/
	public List<Menu> getParentMenuListByRoleId(Integer role_id){
		String sql="select * from menu where menu_id in(select parent_id from role_link_menu as r,menu as m  where r.fk_menu_id = m.menu_id and fk_role_id = ?) and parent_id is null";
		List<Map<String,Object>> list=DBUtil.list(sql,role_id);
		if(list!=null&&list.size()>0){
			List<Menu> menuList=new ArrayList<Menu>();
			for (Map<String,Object> map : list) {
				Menu menu=new Menu();
				try {
					BeanUtils.populate(menu, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menuList.add(menu);
			}
			return menuList;
		}else{
			return null;
		}
	}
	/**根据角色id查询该角色具有的子菜单的权限*/
	public List<Menu> getChildMenuListByRoleId(Integer role_id){
		String sql = "select * from menu where menu_id in(select fk_menu_id from role_link_menu where fk_role_id = ?)"; 
		List<Map<String,Object>> list=DBUtil.list(sql,role_id);
		if(list!=null&&list.size()>0){
			List<Menu> menuList=new ArrayList<Menu>();
			for (Map<String,Object> map : list) {
				Menu menu=new Menu();
				try {
					BeanUtils.populate(menu, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menuList.add(menu);
			}
			return menuList;
		}else{
			return null;
		}
	}
	/**根据role_id查询所具有的子菜单*/
	public List<Menu> getSelectMenuListByRoleId(Integer role_id){
		String sql="select * from menu where menu_id in(select fk_menu_id from role_link_menu where fk_role_id=? )";
		List<Map<String,Object>> list=DBUtil.list(sql, role_id);
		if(list!=null&&list.size()>0){
			List<Menu> menuList=new ArrayList<Menu>();
			for (Map<String,Object> map : list) {
				Menu m=new Menu();
				try {
					BeanUtils.populate(m, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menuList.add(m);
			}
			return menuList;
		}else{
			return null;
		}
	}
	
	/**根据role_id查询所不具有的子菜单*/
	public List<Menu> getUnSelectedMenuListByRoleId(Integer role_id){
		String sql="select * from menu where menu_id not in(select fk_menu_id from role_link_menu where fk_role_id=? ) and parent_id is not null";
		List<Map<String,Object>> list=DBUtil.list(sql, role_id);
		if(list!=null&&list.size()>0){
			List<Menu> menuList=new ArrayList<Menu>();
			for (Map<String,Object> map : list) {
				Menu m=new Menu();
				try {
					BeanUtils.populate(m, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menuList.add(m);
			}
			return menuList;
		}else{
			return null;
		}
	}
}
