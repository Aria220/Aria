package com.yixutech.library.mapper;

import com.yixutech.library.entity.RolePermission;

public interface RolePermissionMapper {
	/**
	 * 增加角色权限
	 * @param role
	 * @return
	 */
	Integer insert(RolePermission rolePermission);
}
