package com.yixutech.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yixutech.demo.entity.User;
import com.yixutech.demo.service.IUserService;
import com.yixutech.demo.service.exception.PasswordNotMatchException;
import com.yixutech.demo.service.exception.UserNotFoundException;
import com.yixutech.demo.service.exception.UserNameConflictException;
import com.yixutech.demo.util.Validator;




@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/reg")
	public String showReg() {
		return "user_reg";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "user_login";
	}
	
	@RequestMapping("/change_password")
	public String showChangePassword() {
		return "user_change_password";
	}
	
	@RequestMapping("/find_password")
	public String showFindPassword() {
		return "user_find_password";
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_reg",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleReg(@RequestParam("userName")String userName,@RequestParam("password")String password,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean result = Validator.checkUsername(userName);
		if (!result) {
			map.put("message", "您输入的用户名格式有误!");
			return ResponseEntity.ok(map);
		}
		result = Validator.checkPassword(password);
		if (!result) {
			map.put("message", "您输入的密码格式有误!");
			return ResponseEntity.ok(map);
		}
		try {
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			userService.reg(user);
			session.setAttribute("uid",user.getId());
			session.setAttribute("userName", user.getUserName());
			String path = getContextPath();
			map.put("message", "注册成功！");
			map.put("url", path+"/main/index");
		} catch (UserNameConflictException e) {
			map.put("message", "用户名已存在！");	
		}
		return ResponseEntity.ok(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_login",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleLogin(@RequestParam("userName") String userName,@RequestParam("password") String password, HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			User user = userService.login(userName, password);
			session.setAttribute("uid",user.getId());
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("accountId", user.getAccountId());
			String path = getContextPath();
			map.put("message", "登录成功");
			map.put("url", path+"/main/index");
			System.out.println(path+"/main/index");
		} catch (UserNotFoundException e) {
			map.put("message", "用户未注册");
		} catch (PasswordNotMatchException e) {
			map.put("message", "密码错误");
		}
		return ResponseEntity.ok(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_change_password",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleChangePassword(@RequestParam("password") String password,@RequestParam("newPassword") String newPassword, HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Integer uid = getUidFromSession(session);
			userService.changePassword(uid, password, newPassword);
			String path = getContextPath();
			map.put("message", "修改成功");
			map.put("url", path+"/main/index");
			System.out.println(path+"/main/index");
		} catch (PasswordNotMatchException e) {
			map.put("message", "原密码错误");
		} 
		return ResponseEntity.ok(map);
	}
	
	
	
	
	
	
}
