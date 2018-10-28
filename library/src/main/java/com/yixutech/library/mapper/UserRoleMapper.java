package com.yixutech.library.mapper;

import com.yixutech.library.entity.UserRole;

public interface UserRoleMapper {
	/**
	 * 增加用户角色对应信息
	 * @param role
	 * @return
	 */
	Integer insert(UserRole userRole);
}
