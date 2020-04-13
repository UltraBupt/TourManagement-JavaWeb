package com.gs.tour.shxt.leave.model;

public class Leave {
	Integer leave_id;
	Integer fk_user_id;
	String leave_name;
	String leave_branch;
	String leave_role;
	String leave_day;
	String leave_desc;
	String leave_startDay;
	String leave_overDay;
	String leave_agreeUser;
	Integer leave_status;
	public Integer getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}
	public Integer getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(Integer fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getLeave_name() {
		return leave_name;
	}
	public void setLeave_name(String leave_name) {
		this.leave_name = leave_name;
	}
	public String getLeave_branch() {
		return leave_branch;
	}
	public void setLeave_branch(String leave_branch) {
		this.leave_branch = leave_branch;
	}
	public String getLeave_role() {
		return leave_role;
	}
	public void setLeave_role(String leave_role) {
		this.leave_role = leave_role;
	}
	public String getLeave_day() {
		return leave_day;
	}
	public void setLeave_day(String leave_day) {
		this.leave_day = leave_day;
	}
	public String getLeave_desc() {
		return leave_desc;
	}
	public void setLeave_desc(String leave_desc) {
		this.leave_desc = leave_desc;
	}
	public String getLeave_startDay() {
		return leave_startDay;
	}
	public void setLeave_startDay(String leave_startDay) {
		this.leave_startDay = leave_startDay;
	}
	public String getLeave_overDay() {
		return leave_overDay;
	}
	public void setLeave_overDay(String leave_overDay) {
		this.leave_overDay = leave_overDay;
	}
	public String getLeave_agreeUser() {
		return leave_agreeUser;
	}
	public void setLeave_agreeUser(String leave_agreeUser) {
		this.leave_agreeUser = leave_agreeUser;
	}
	public Integer getLeave_status() {
		return leave_status;
	}
	public void setLeave_status(Integer leave_status) {
		this.leave_status = leave_status;
	}
}
