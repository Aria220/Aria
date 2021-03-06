package com.yixutech.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class CurriculumVitae implements Serializable{
	
	private static final long serialVersionUID = -3970827670520133507L;
	
	private Integer id;
	private Integer accountId;
	private String company;
	private String department;
	private String position;
	private Date hireDate;
	private Date leaveDate;
	private Integer cancel;
	private String inputUser;
	private Date inputTime;
	private String updateUser;
	private Date updateTime;
	private String remarks;
	public CurriculumVitae() {
		super();
	}
	
	public CurriculumVitae(Integer accountId, String company, String department, String position, Date hireDate,
			Date leaveDate, Integer cancel, String inputUser, Date inputTime, String updateUser, Date updateTime,
			String remarks) {
		super();
		setAccountId(accountId);
		setCompany(company);
		setDepartment(department);
		setPosition(position);
		setHireDate(hireDate);
		setLeaveDate(leaveDate);
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
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
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
		return "CurriculumVitae [id=" + id + ", accountId=" + accountId + ", company=" + company + ", department="
				+ department + ", positon=" + position + ", hireDate=" + hireDate + ", leaveDate=" + leaveDate
				+ ", cancel=" + cancel + ", inputUser=" + inputUser + ", inputTime=" + inputTime + ", updateUser="
				+ updateUser + ", updateTime=" + updateTime + ", remarks=" + remarks + "]";
	}
	
}
