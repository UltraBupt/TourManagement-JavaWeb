package com.gs.tour.shxt.salary.service;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.salary.dao.SalaryDao;
import com.gs.tour.shxt.salary.model.Salary;

public class SalaryService {
	SalaryDao salaryDao=new SalaryDao();
	/**查询薪资列表*/
	public PageBean getAllSalaryList(Salary salary,PageBean pageBean){
		return this.salaryDao.getAllSalaryList(salary, pageBean);
	}
	/**验证角色是否重复
	 * @throws Exception */
	public void checkRole(Integer fk_role_id) throws Exception{
		Integer num=this.salaryDao.checkRole(fk_role_id);
		if(num>0){
			throw new Exception("角色已经存在，请重新输入");
		}
	}
	/**添加薪资
	 * @throws Exception */
	public void addSalary(Integer fk_role_id,String salary_number) throws Exception{
		Integer num=this.salaryDao.addSalary(fk_role_id, salary_number);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**根据薪资id获取薪资*/
	public Salary querySalaryBySalaryId(Integer salary_id){
		return this.salaryDao.querySalaryBySalaryId(salary_id);
	}
	/**编辑薪资
	 * @throws Exception */
	public void updateSalary(String salary_number,Integer salary_id) throws Exception{
		Integer num=this.salaryDao.updateSalary(salary_number, salary_id);
		if(num<=0){
			throw new Exception("编辑失败");
		}
	}
	/**根据用户id获取用户薪资*/
	public Salary querySalaryByUserId(Integer user_id){
		return this.salaryDao.querySalaryByUserId(user_id);
	}
}
