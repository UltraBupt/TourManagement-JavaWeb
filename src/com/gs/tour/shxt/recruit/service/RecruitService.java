package com.gs.tour.shxt.recruit.service;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.recruit.dao.RecruitDao;
import com.gs.tour.shxt.recruit.model.Recruit;

public class RecruitService {
	RecruitDao recruitDao=new RecruitDao();
	/**查询招聘信息*/
	public PageBean getAllRecruitList(Recruit recruit,PageBean pageBean){
		return this.recruitDao.getAllRecruitList(recruit, pageBean);
	}
	/**添加招聘信息
	 * @throws Exception */
	public void addRecruit(Recruit recruit) throws Exception{
		Integer num=this.recruitDao.addRecruit(recruit);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**根据招聘信息id获取角色*/
	public Recruit queryRecruitByRecruitId(Integer recruit_id){
		return this.recruitDao.queryRecruitByRecruitId(recruit_id);
	}
	/**更改招聘信息状态*/
	public Integer updateStatus(Integer recruit_id){
		Recruit recruit=this.recruitDao.queryRecruitByRecruitId(recruit_id);
		Integer recruit_status = recruit.getRecruit_status();
		if(recruit_status==1){
			recruit_status=0;
		}else{
			recruit_status=1;
		}
		this.recruitDao.updateStatus(recruit_id, recruit_status);
		return recruit_status;
	}
	/**编辑招聘信息
	 * @throws Exception */
	public void updateRecruit(Recruit recruit) throws Exception{
		Integer num=this.recruitDao.updateRecruit(recruit);
		if(num<=0){
			throw new Exception("编辑失败");
		}
	}
}
