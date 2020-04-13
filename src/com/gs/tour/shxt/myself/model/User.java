package com.gs.tour.shxt.myself.model;

public class User {
	private Integer user_id;
	private String account;
	private String password;
	private String user_name;
	private String user_code;
	private String user_tel;
	private String user_sex;
	private String user_photo_url;
	private String user_email;
	private Integer user_status;
	public Integer getUser_status() {
		return user_status;
	}
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}
	private Integer fk_salary_id;
	public Integer getFk_salary_id() {
		return fk_salary_id;
	}
	public void setFk_salary_id(Integer fk_salary_id) {
		this.fk_salary_id = fk_salary_id;
	}
	private Integer fk_role_id;
	private Integer fk_org_id;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_photo_url() {
		return user_photo_url;
	}
	public void setUser_photo_url(String user_photo_url) {
		this.user_photo_url = user_photo_url;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Integer getFk_role_id() {
		return fk_role_id;
	}
	public void setFk_role_id(Integer fk_role_id) {
		this.fk_role_id = fk_role_id;
	}
	public Integer getFk_org_id() {
		return fk_org_id;
	}
	public void setFk_org_id(Integer fk_org_id) {
		this.fk_org_id = fk_org_id;
	}
}
