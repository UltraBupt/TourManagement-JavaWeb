package com.gs.tour.shxt.role.service;

import java.util.List;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.role.dao.RoleDao;
import com.gs.tour.shxt.role.model.Role;

public class RoleService {
	RoleDao roleDao=new RoleDao();
	/**查询全部可用角色*/
	public List<Role> getRoleList(){
		return this.roleDao.getRoleList();
	}
	/**查询角色列表*/
	public PageBean getAllRoleList(Role role,PageBean pageBean){
		return this.roleDao.getAllRoleList(role, pageBean);
	}
	/**验证角色名是否重复
	 * @throws Exception */
	public void checkRoleName(String role_name) throws Exception{
		Integer num=this.roleDao.checkRoleName(role_name);
		if(num>0){
			throw new Exception("角色名已存在，请重新输入");
		}
	}
	/**添加角色
	 * @throws Exception */
	public void addRole(String role_name,String role_desc) throws Exception{
		Integer num=this.roleDao.addRole(role_name, role_desc);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**根据角色id获取角色*/
	public Role queryRoleByRoleId(Integer role_id){
		return this.roleDao.queryRoleByRoleId(role_id);
	}
	/**编辑角色
	 * @throws Exception */
	public void updateRole(String role_name,String role_desc,Integer role_id) throws Exception{
		Integer num=this.roleDao.updateRole(role_name, role_desc, role_id);
		if(num<=0){
			throw new Exception("编辑失败");
		}
	}
	/**更改角色状态*/
	public Integer updateStatus(Integer role_id) throws Exception {
		Role role = this.roleDao.queryRoleByRoleId(role_id);
		Integer role_status = role.getRole_status();
		if(role_status==1){
			role_status=0;
		}else{
			role_status=1;
		}
		this.roleDao.updateStatus(role_id, role_status);
		return role_status;
	}
	/**分配角色
	 * @throws Exception */
	public void distributeMenuByRoleId(Integer role_id,String[]menus) throws Exception{
		Integer num=this.roleDao.deleteMenuByRoleId(role_id);
		if(num>=0){
			this.roleDao.distributeMenuByRoleId(role_id, menus);
		}else{
			throw new Exception("删除旧数据失败");
		}
	}
}
