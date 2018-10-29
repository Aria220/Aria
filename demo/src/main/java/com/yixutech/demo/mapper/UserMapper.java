package com.yixutech.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yixutech.demo.entity.User;

public interface UserMapper {
	/**
	 * 插入用户数据
	 * @param user
	 * @return
	 */
	Integer insert(User user);
	/**
	 * 通过用户名查找用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	/**
	 * 通过id查找用户
	 * @param id
	 * @return
	 */
	User findUserById(Long id);
	/**
	 * 查询所有用户数据
	 * @return 用户数据
	 */
	List<User> findAllUsers();
	/**
	 * 修改密码 需验证
	 * @param id
	 * @param password
	 * @return 行数
	 */
	Integer changePassword(@Param("id")Long id,@Param("password")String password);
	/**
	 * 删除数据 需验证
	 * @param id
	 * @param password
	 * @return
	 */
	Integer delete(@Param("id")Long id,@Param("password")String password);
}
