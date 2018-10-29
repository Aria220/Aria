package com.yixutech.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Administrator implements Serializable{
	
	private static final long serialVersionUID = 5731149449112921807L;
	
	private Integer id;
	private String userName;
	private String password;
	private Integer authority;
	private Integer cancel;
	private String inputUser;
	private Date inputTime;
	private String updateUser;
	private Date updateTime;
	private String remarks;
	
	public Administrator() {
		super();
	}

	public Administrator(String userName, String password, Integer autority, Integer cancel, String inputUser,
			Date inputTime, String updateUser, Date updateTime, String remarks) {
		super();
		setUserName(userName);
		setPassword(password);
		setAutority(autority);
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

	public Integer getAuthority() {
		return authority;
	}

	public void setAutority(Integer authority) {
		this.authority = authority;
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
		return "Administrator [id=" + id + ", userName=" + userName + ", password=" + password + ", autority="
				+ authority + ", cancel=" + cancel + ", inputUser=" + inputUser + ", inputTime=" + inputTime
				+ ", updateUser=" + updateUser + ", updateTime=" + updateTime + ", remarks=" + remarks + "]";
	}
	
	
}
