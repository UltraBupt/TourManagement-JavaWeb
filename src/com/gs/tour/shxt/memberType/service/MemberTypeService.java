package com.gs.tour.shxt.memberType.service;


import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.memberType.dao.MemberTypeDao;
import com.gs.tour.shxt.memberType.model.MemberType;

public class MemberTypeService {
	MemberTypeDao memberTypeDao=new MemberTypeDao();
	/**查询会员类型列表*/
	public PageBean getAllMemberTypeList(MemberType memberType,PageBean pageBean){
		return this.memberTypeDao.getAllMemberTypeList(memberType, pageBean);
	}
	/**验证会员类型是否重复*/
	public void checkMemberTypeName(String memberType_name) throws Exception{
		Integer num=this.memberTypeDao.checkMemberTypeName(memberType_name);
		if(num>0){
			throw new Exception("该会员类型已经存在，请重新输入");
		}
	}
	/**添加会员类型
	 * @throws Exception */
	public void addMemberType(String memberType_name,Integer memberType_number,String memberType_desc,String memberType_benefit) throws Exception{
		Integer num=this.memberTypeDao.addMemberType(memberType_name, memberType_number, memberType_desc, memberType_benefit);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public MemberType load(Integer memberType_id){
		MemberType memberType;
		try {
			memberType=this.memberTypeDao.load(memberType_id);
			return memberType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑会员类型*/
	public void update(MemberType memberType){
		this.memberTypeDao.update(memberType);
	}
	/**根据会员类型id获取角色*/
	public MemberType queryMemberTypeByMemberTypeId(Integer memberType_id){
		return this.memberTypeDao.queryMemberTypeByMemberTypeId(memberType_id);
	}
	/**更改会员类型状态*/
	public Integer updateStatus(Integer memberType_id){
		MemberType memberType=this.memberTypeDao.queryMemberTypeByMemberTypeId(memberType_id);
		Integer memberType_status=memberType.getMemberType_status();
		if(memberType_status==1){
			memberType_status=0;
		}else{
			memberType_status=1;
		}
		this.memberTypeDao.updateStatus(memberType_id, memberType_status);
		return memberType_status;
	}
}
