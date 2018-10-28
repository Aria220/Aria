package com.yixutech.library.entity;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = 3210916611632612623L;

	private Long id;
	private Long userId;
	private Long roleId;

	public UserRole() {
		super();
	}
	
	public UserRole(Long userId, Long roleId) {
		super();
		setUserId(userId);
		setRoleId(roleId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userId=" + userId + ", roleId=" + roleId + "]";
	}

}
