package com.gs.tour.shxt.menu.service;

import java.util.List;

import com.gs.tour.shxt.menu.dao.MenuDao;
import com.gs.tour.shxt.menu.model.Menu;

public class MenuService {
	MenuDao menuDao=new MenuDao();
	/**根据角色id查询该角色具有的父菜单的权限*/
	public List<Menu> getParentMenuListByRoleId(Integer role_id){
		return this.menuDao.getParentMenuListByRoleId(role_id);
	}
	/**根据角色id查询该角色具有的子菜单的权限*/
	public List<Menu> getChildMenuListByRoleId(Integer role_id){
		return this.menuDao.getChildMenuListByRoleId(role_id);
	}
	/**根据role_id查询所具有的子菜单*/
	public List<Menu> getSelectMenuListByRoleId(Integer role_id){
		return this.menuDao.getSelectMenuListByRoleId(role_id);
	}

	/**根据role_id查询所不具有的子菜单*/
	public List<Menu> getUnSelectedMenuListByRoleId(Integer role_id){
		return this.menuDao.getUnSelectedMenuListByRoleId(role_id);
	}
}
