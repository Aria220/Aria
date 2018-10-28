package com.yixutech.library.mapper;

import com.yixutech.library.entity.Permission;


public interface PermissionMapper {
	/**
	 * 增加权限信息
	 * @param role
	 * @return
	 */
	Integer insert(Permission permission);
}
