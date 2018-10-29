package com.yixutech.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1444584456669123645L;
	
	private Integer id;
	private String userName;
	private String password;
	private Integer accountId;
	private Integer state;
	private Integer cancel; 
	private String inputUser;
	private Date inputTime;
	private String updateUser;
	private Date updateTime;
	private String remarks;
	
	public User() {
		super();
	}
	
	public User(String userName, String password, Integer accountId, Integer state, Integer cancel, String inputUser,
			Date inputTime, String updateUser, Date updateTime, String remarks) {
		super();
		setUserName(userName);
		setPassword(password);
		setAccountId(accountId);
		setState(state);
		setCancel(cancel);
		setInputUser(inputUser);
		setInputTime(inputTime);
		setUpdateUser(updateUser);
		setUpdateTime(updateTime);
		setRemarks(remarks);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getCancel() {
		return cancel;
	}
	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}
	public String getInputUser() {
		return inputUser;
	}
	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", accountId=" + accountId
				+ ", state=" + state + ", cancel=" + cancel + ", inputUser=" + inputUser + ", inputTime=" + inputTime
				+ ", updateUser=" + updateUser + ", updateTime=" + updateTime + ", remarks=" + remarks + "]";
	}
	
}
