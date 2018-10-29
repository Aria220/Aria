package com.yixutech.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.yixutech.demo.entity.User;
import com.yixutech.demo.mapper.UserMapper;
import com.yixutech.demo.service.exception.PasswordNotMatchException;
import com.yixutech.demo.service.exception.UserNotFoundException;
import com.yixutech.demo.service.exception.UsernameConflictException;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;

	public User reg(User user) {
		User data = findUserByUsername(user.getUserName());
		if(data==null) {
			String salt = UUID.randomUUID().toString();
			String md5Password = getEncryptedPassword(user.getPassword());
			user.setPassword(md5Password);
			userMapper.insert(user);
			return user;
		} else {
			throw new UsernameConflictException("用户名"+user.getUserName()+"已存在");
		}
		
	}

	public User login(String username, String password) {
		User user = findUserByUsername(username);
		if(user!=null) {
			String pwd = getEncryptedPassword(password);
			if(pwd.equals(user.getPassword())) {
				user.setPassword(null);
				user.setUserName(null);
				return user;
			} else {
				throw new PasswordNotMatchException("密码错误");
			}
		} else {
			throw new UserNotFoundException("用户不存在");
		}

	}

	public Integer changePassword(Long id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUserById(Long id) {
		return userMapper.findUserById(id);
	}

	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	public String getEncryptedPassword(String password) {
		password = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		return password;
	}


}
