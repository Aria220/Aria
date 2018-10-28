package com.yixutech.library.entity;

import java.io.Serializable;

public class RolePermission implements Serializable {

	private static final long serialVersionUID = -3049758390913527713L;

	private Long id;
	private Long roleId;
	private Long permissionId;

	public RolePermission() {
		super();
	}

	public RolePermission(Long roleId, Long permissionId) {
		super();
		setRoleId(roleId);
		setPermissionId(permissionId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}

}
