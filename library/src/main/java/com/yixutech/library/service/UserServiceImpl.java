package com.yixutech.library.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.yixutech.library.entity.User;
import com.yixutech.library.mapper.UserMapper;
import com.yixutech.library.service.exception.PasswordNotMatchException;
import com.yixutech.library.service.exception.UserNotFoundException;
import com.yixutech.library.service.exception.UsernameConflictException;


@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	public User reg(User user) {
		User data = findUserByUsername(user.getUsername());
		if(data==null) {
			String salt = UUID.randomUUID().toString();
			String md5Password = getEncryptedPassword(user.getPassword(), salt);
			user.setSalt(salt);
			user.setPassword(md5Password);
			userMapper.insert(user);
			return user;
		} else {
			throw new UsernameConflictException("用户名"+user.getUsername()+"已存在");
		}
		
	}

	public User login(String username, String password) {
		User user = findUserByUsername(username);
		if(user!=null) {
			String salt = user.getSalt();
			String pwd = getEncryptedPassword(password, salt);
			if(pwd.equals(user.getPassword())) {
				user.setPassword(null);
				user.setUsername(null);
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

	public String getEncryptedPassword(String password, String salt) {
		String str1 = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		String str2 = str1 + salt.toUpperCase();
		String str3 = DigestUtils.md5DigestAsHex(str2.getBytes()).toUpperCase();
		return str3;
	}

}
