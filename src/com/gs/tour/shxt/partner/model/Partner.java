package com.gs.tour.shxt.partner.model;

public class Partner {
	Integer partner_id;
	String partner_name;
	String partner_position;
	String partner_type;
	String partner_hobby;
	Integer partner_status;
	String partner_desc;
	Integer fk_partnerType_id;
	public Integer getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}
	public String getPartner_position() {
		return partner_position;
	}
	public void setPartner_position(String partner_position) {
		this.partner_position = partner_position;
	}
	public String getPartner_type() {
		return partner_type;
	}
	public void setPartner_type(String partner_type) {
		this.partner_type = partner_type;
	}
	public String getPartner_hobby() {
		return partner_hobby;
	}
	public void setPartner_hobby(String partner_hobby) {
		this.partner_hobby = partner_hobby;
	}
	public Integer getPartner_status() {
		return partner_status;
	}
	public void setPartner_status(Integer partner_status) {
		this.partner_status = partner_status;
	}
	public String getPartner_desc() {
		return partner_desc;
	}
	public void setPartner_desc(String partner_desc) {
		this.partner_desc = partner_desc;
	}
	public Integer getFk_partnerType_id() {
		return fk_partnerType_id;
	}
	public void setFk_partnerType_id(Integer fk_partnerType_id) {
		this.fk_partnerType_id = fk_partnerType_id;
	}
}
