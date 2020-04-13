package com.gs.tour.shxt.user.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.user.dao.UserDao;
import com.gs.tour.shxt.user.model.User;

public class UserService {
	UserDao userDao=new UserDao();
	/**登录验证
	 * @throws Exception */
	public User login(String account,String password) throws Exception{
		User user=this.userDao.login(account, password);
		if(user!=null){
			Integer user_status=user.getUser_status();
			if(user_status==1){
				Integer role_id=user.getFk_role_id();
				if(role_id==0){
					throw new Exception("该账号未分配角色无法登陆");
				}else{
					return user;
				}
			}else if(user_status==0){
				throw new Exception("该账号已禁用请联系管理员");
			}else{
				throw new Exception("该账号已注销");
			}
		}else{
			throw new Exception("账号密码不匹配请重新输入");
		}
	}
	/**查询员工列表*/
	public PageBean getAllUserList(User user,PageBean pageBean){
		return this.userDao.getAllUserList(user, pageBean);
	}
	/**验证账号是否重复
	 * @throws Exception */
	public void checkAccount(String account) throws Exception{
		Integer num=this.userDao.checkAccount(account);
		if(num>0){
			throw new Exception("账号已存在，请重新输入");
		}
	}
	/**添加员工
	 * @throws Exception */
	public void addUser(String account,String password,String user_name) throws Exception{
		Integer num=this.userDao.addUser(account, password, user_name);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public User load(Integer user_id){
		User user;
		try {
			user=this.userDao.load(user_id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑员工*/
	public void update(User user){
		this.userDao.update(user);
	}
	/**上传头像
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.userDao.upload(map);
		if(num<=0){
			throw new Exception("上传头像失败");
		}
	}
	/**根据用户ID查询详细信息*/
	public User queryUserByUserId(Integer user_id){
		return this.userDao.queryUserByUserId(user_id);
	}
	/**分配角色
	 * @throws Exception */
	public void updateUserRoleByUserId(Integer fk_role_id,Integer user_id) throws Exception{
		User user=new User();
		user.setFk_role_id(fk_role_id);
		user.setUser_id(user_id);
		Integer num=this.userDao.updateUserByUserId(user);
		if(num<=0){
			throw new Exception("分配角色失败");
		}
	}
	/**修改密码*/
	public void updatePassword(Integer user_id,String password) throws Exception {
		try {
			this.userDao.updatePassword(user_id, password);
		} catch (Exception e) {
			throw new Exception("密码修改失败！");
		}
	}
	/**编辑个人信息
	 * @throws Exception */
	public void updateMyselfInformation(User user) throws Exception{
		Integer num=this.userDao.updateMyselfInformation(user);
		if(num<=0){
			throw new Exception("编辑失败");
		}
	}
}
