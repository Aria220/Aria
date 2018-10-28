package com.yixutech.library.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private static final long serialVersionUID = 5472916968071069709L;
	
	private Long id;
	private String username;
	private String password;
	private String salt;
	private String realname;
	private String email;
	private String phone;
	private Integer gender;
	private Date birthday;

	public User() {
		super();
	}

	public User(String username, String password, String salt, String realname, String email, String phone,
			Integer gender, Date birthday) {
		super();
		setUsername(username);
		setPassword (password);
		setSalt(salt);
		setRealname(realname);
		setEmail(email);
		setPhone(phone);
		setGender(gender);
		setBirthday(birthday);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", realName="
				+ realname + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", birthday=" + birthday
				+ "]";
	}

}
