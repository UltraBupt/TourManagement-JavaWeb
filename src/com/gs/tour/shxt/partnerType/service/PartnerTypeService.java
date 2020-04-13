package com.gs.tour.shxt.partnerType.service;


import java.util.List;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.partnerType.dao.PartnerTypeDao;
import com.gs.tour.shxt.partnerType.model.PartnerType;

public class PartnerTypeService {
	PartnerTypeDao partnerTypeDao=new PartnerTypeDao();
	/**查询合作商类型列表*/
	public PageBean getAllPartnerTypeList(PartnerType partnerType,PageBean pageBean){
		return this.partnerTypeDao.getAllPartnerTypeList(partnerType, pageBean);
	}
	/**验证合作商类型是否重复
	 * @throws Exception */
	public void checkPartnerTypeName(String partnerType_name) throws Exception{
		Integer num=this.partnerTypeDao.checkPartnerTypeName(partnerType_name);
		if(num>0){
			throw new Exception("该合作商;型已存在，请重新输入");
		}
	}
	/**添加合作商类型
	 * @throws Exception */
	public void addPartnerType(String partnerType_name,String partnerType_desc) throws Exception{
		Integer num=this.partnerTypeDao.addPartnerType(partnerType_name, partnerType_desc);
		if(num<=0){
			throw new Exception("添加合作商类型失败");
		}
	}
	/**更新*/
	public PartnerType load(Integer partnerType_id){
		PartnerType partnerType;
		try {
			partnerType=this.partnerTypeDao.load(partnerType_id);
			return partnerType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑供应商类别*/
	public void update(PartnerType partnerType){
		this.partnerTypeDao.update(partnerType);
	}
	/**根据供应商id获取供应商*/
	public PartnerType queryPartnerTypeByPartnerTypeId(Integer partnerType_id){
		return this.partnerTypeDao.queryPartnerTypeByPartnerTypeId(partnerType_id);
	}
	/**更改供应商类型状态*/
	public Integer updateStatus(Integer partnerType_id){
		PartnerType partnerType=this.partnerTypeDao.queryPartnerTypeByPartnerTypeId(partnerType_id);
		Integer partnerType_status=partnerType.getPartnerType_status();
		if(partnerType_status==1){
			partnerType_status=0;
		}else{
			partnerType_status=1;
		}
		this.partnerTypeDao.updateStatus(partnerType_id, partnerType_status);
		return partnerType_status;
	}
	/**查询全部可用合作商类型*/
	public List<PartnerType> getAllPartnerType(){
		return this.partnerTypeDao.getAllPartnerType();
	}
}
