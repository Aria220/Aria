package com.yixutech.demo.controller;

import java.util.Date;
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
import com.yixutech.demo.service.exception.UsernameConflictException;
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
	
	@ResponseBody
	@RequestMapping(value="/handle_reg",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleReg(User user){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean result = Validator.checkUsername(user.getUserName());
		if (!result) {
			map.put("message", "您输入的用户名格式有误!");
			return ResponseEntity.ok(map);
		}
		result = Validator.checkPassword(user.getPassword());
		if (!result) {
			map.put("message", "您输入的密码格式有误!");
			return ResponseEntity.ok(map);
		}
		try {
			User data = new User();
			userService.reg(data);
			map.put("message", "注册成功！");
		} catch (UsernameConflictException e) {
			map.put("message", "用户名已存在！");	
		}
		return ResponseEntity.ok(map);
	}
	
//	@ResponseBody
//	@RequestMapping(value="/handle_login.do",method=RequestMethod.POST)
//	public ResponseResult<Void> handleLogin(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session){
//		ResponseResult<Void> rr;
//		try {
//			User user = userService.findUserByUsername(username);
//			session.setAttribute("id",user.getId());
//			session.setAttribute("username", user.getUsername());
//			rr = new ResponseResult<Void>(ResponseResult.STATE_OK);
//		} catch (UserNotFoundException e) {
//			rr = new ResponseResult<Void>(-1, "用户未注册");
//		} catch (PasswordNotMatchException e) {
//			rr = new ResponseResult<Void>(-2, "密码错误");
//		}
//		return rr;
//	}
	@ResponseBody
	@RequestMapping(value="/handle_login.do",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleLogin(@RequestParam("userName") String userName,@RequestParam("password") String password, HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			User user = userService.findUserByUsername(userName);
			session.setAttribute("uid",user.getId());
			session.setAttribute("username", user.getUserName());
			String path = getContextPath();
			map.put("message", "登录成功");
			map.put("url", path+"/main/index");
		} catch (UserNotFoundException e) {
			map.put("message", "用户未注册");
		} catch (PasswordNotMatchException e) {
			map.put("message", "密码错误");
		}
		return ResponseEntity.ok(map);
	}
	
	
	
	
	
	
	
	
}
