package com.yixutech.library.service;

import com.yixutech.library.entity.User;

public interface IUserService {
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	User reg(User user);
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username,String password);
	/**
	 * 修改密码
	 * @param id 
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	Integer changePassword(Long id,String oldPassword,String newPassword);
	/**
	 * 通过id查找用户数据
	 * @param id
	 * @return
	 */
	User findUserById(Long id);
	/**
	 * 通过用户名查找用户数据
	 * @param usernam
	 * @return
	 */
	User findUserByUsername(String usernam);
	/**
	 * 对密码加密
	 * @param password
	 * @param salt
	 * @return
	 */
	String getEncryptedPassword(String password, String salt);
}
