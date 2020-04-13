package com.gs.tour.shxt.a.web.register.model;

public class Member {
	Integer member_id;
	String member_name;
	String member_account;
	String member_password;
	Integer member_number;
	String member_type;
	String member_benefit;
	Integer member_status;
	Integer fk_memberType_id;
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_account() {
		return member_account;
	}
	public void setMember_account(String member_account) {
		this.member_account = member_account;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public Integer getMember_number() {
		return member_number;
	}
	public void setMember_number(Integer member_number) {
		this.member_number = member_number;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	public String getMember_benefit() {
		return member_benefit;
	}
	public void setMember_benefit(String member_benefit) {
		this.member_benefit = member_benefit;
	}
	public Integer getMember_status() {
		return member_status;
	}
	public void setMember_status(Integer member_status) {
		this.member_status = member_status;
	}
	public Integer getFk_memberType_id() {
		return fk_memberType_id;
	}
	public void setFk_memberType_id(Integer fk_memberType_id) {
		this.fk_memberType_id = fk_memberType_id;
	}
}
