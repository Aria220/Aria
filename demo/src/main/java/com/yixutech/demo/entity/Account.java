package com.yixutech.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {

	private static final long serialVersionUID = -2210987757015777180L;

	private Integer id;
	private String realName;
	private String birthday;
	private Integer gender;
	private String mobileNumber;
	private String eMail;
	private String address;
	private Integer education;
	private Integer state;
	private Integer cancel;
	private String inputUser;
	private Date inputTime;
	private String updateUser;
	private Date updateTime;
	private String remarks;

	public Account() {
		super();
	}

	public Account(String realName, String birthday, Integer gender, String mobileNumber, String eMail, String address,
			Integer education, Integer state, Integer cancel, String inputUser, Date inputTime, String updateUser,
			Date updateTime, String remarks) {
		super();
		setRealName(realName);
		setBirthday(birthday);
		setGender(gender);
		setMobileNumber(mobileNumber);
		seteMail(eMail);
		setAddress(address);
		setEducation(education);
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
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
		return "IUserservice [id=" + id + ", realName=" + realName + ", birthday=" + birthday + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", eMail=" + eMail + ", address=" + address + ", education="
				+ education + ", state=" + state + ", cancel=" + cancel + ", inputUser=" + inputUser + ", inputTime="
				+ inputTime + ", updateUser=" + updateUser + ", updateTime=" + updateTime + ", remarks=" + remarks
				+ "]";
	}

}
