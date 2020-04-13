package com.gs.tour.shxt.partner.service;


import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.partner.dao.PartnerDao;
import com.gs.tour.shxt.partner.model.Partner;

public class PartnerService {
	PartnerDao partnerDao=new PartnerDao();
	/**查询合作商列表*/
	public PageBean getAllPartnerList(Partner partner,PageBean pageBean){
		return this.partnerDao.getAllPartnerList(partner, pageBean);
	}
	/**添加合作商
	 * @throws Exception */
	public void addPartner(Integer fk_partnerType_id,String partner_name,String partner_position,String partner_hobby,String partner_desc) throws Exception{
		Integer num=this.partnerDao.addPartner(fk_partnerType_id, partner_name, partner_position, partner_hobby, partner_desc);
		if(num<=0){
			throw new Exception("合作商添加失败");
		}
	}
	/**更新*/
	public Partner load(Integer partner_id){
		Partner partner;
		try {
			partner=this.partnerDao.load(partner_id);
			return partner;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑合作商*/
	public void update(Partner partner){
		this.partnerDao.update(partner);
	}
	/**更改合作商状态*/
	public Integer updateStatus(Integer partner_id){
		Partner partner=this.partnerDao.queryPartnerByPartnerId(partner_id);
		Integer partner_status=partner.getPartner_status();
		if(partner_status==1){
			partner_status=0;
		}else{
			partner_status=1;
		}
		this.partnerDao.updateStatus(partner_id, partner_status);
		return partner_status;
	}
}
