package com.gs.tour.shxt.message.model;

public class NewMessage {
	Integer newMessage_id;
	String newMessage_desc;
	String newMessage_createDate;
	Integer newMessage_status;
	String newMessageMember_name;
	String newMessageMember_account;
	public Integer getNewMessage_id() {
		return newMessage_id;
	}
	public void setNewMessage_id(Integer newMessage_id) {
		this.newMessage_id = newMessage_id;
	}
	public String getNewMessage_desc() {
		return newMessage_desc;
	}
	public void setNewMessage_desc(String newMessage_desc) {
		this.newMessage_desc = newMessage_desc;
	}
	public String getNewMessage_createDate() {
		return newMessage_createDate;
	}
	public void setNewMessage_createDate(String newMessage_createDate) {
		this.newMessage_createDate = newMessage_createDate;
	}
	public Integer getNewMessage_status() {
		return newMessage_status;
	}
	public void setNewMessage_status(Integer newMessage_status) {
		this.newMessage_status = newMessage_status;
	}
	public String getNewMessageMember_name() {
		return newMessageMember_name;
	}
	public void setNewMessageMember_name(String newMessageMember_name) {
		this.newMessageMember_name = newMessageMember_name;
	}
	public String getNewMessageMember_account() {
		return newMessageMember_account;
	}
	public void setNewMessageMember_account(String newMessageMember_account) {
		this.newMessageMember_account = newMessageMember_account;
	}
}
