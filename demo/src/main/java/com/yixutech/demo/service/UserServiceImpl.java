package com.yixutech.demo.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.yixutech.demo.entity.Account;
import com.yixutech.demo.entity.User;
import com.yixutech.demo.mapper.AccountMapper;
import com.yixutech.demo.mapper.UserMapper;
import com.yixutech.demo.service.exception.PasswordNotMatchException;
import com.yixutech.demo.service.exception.UserNotFoundException;
import com.yixutech.demo.service.exception.UserNameConflictException;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	private AccountMapper accountMapper;

	public User reg(User user) {
		User data = findUserByUserName(user.getUserName());
		if(data==null) {
			String md5Password = getEncryptedPassword(user.getPassword());
			user.setPassword(md5Password);
			Account account = new Account(null, null, 1, "186xxxxxxxx", "xx@xx.com", "xx市", 2, 1, 1, user.getUserName(), new Date(),user.getUserName(), new Date(), "备注");
			user.setState(1);
			user.setCancel(1);
			user.setInputTime(new Date());
			user.setInputUser(user.getUserName());
			user.setUpdateTime(new Date());
			user.setUpdateUser(user.getUserName());
			accountMapper.insert(account);
			Integer accountId = account.getId();
			user.setAccountId(accountId);
			userMapper.insert(user);
			return user;
		} else {
			throw new UserNameConflictException("用户名"+user.getUserName()+"已存在");
		}
		
	}

	public User login(String username, String password) {
		User user = findUserByUserName(username);
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

	public Integer changePassword(Integer uid, String oldPassword, String newPassword) {
		User user = userMapper.findUserById(uid);
		String password = getEncryptedPassword(oldPassword);
		if(password.equals(user.getPassword())) {
			password = getEncryptedPassword(newPassword);
			user.setPassword(password);
			Integer row = userMapper.changePassword(uid, password);
			return row;
		} else {
			throw new PasswordNotMatchException();
		}
	}

	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}

	public User findUserByUserName(String username) {
		return userMapper.findUserByUserName(username);
	}

	public String getEncryptedPassword(String password) {
		System.out.println(password);
		password = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		return password;
	}

	
}
