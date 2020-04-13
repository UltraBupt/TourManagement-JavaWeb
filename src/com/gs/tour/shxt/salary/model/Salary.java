package com.gs.tour.shxt.salary.model;

public class Salary {
	Integer salary_id;
	String salary_number;
	Integer fk_role_id;
	String position_name;
	public Integer getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(Integer salary_id) {
		this.salary_id = salary_id;
	}
	public String getSalary_number() {
		return salary_number;
	}
	public void setSalary_number(String salary_number) {
		this.salary_number = salary_number;
	}
	public Integer getFk_role_id() {
		return fk_role_id;
	}
	public void setFk_role_id(Integer fk_role_id) {
		this.fk_role_id = fk_role_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
}
