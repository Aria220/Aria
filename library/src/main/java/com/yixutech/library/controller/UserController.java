package com.yixutech.library.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yixutech.library.entity.ResponseResult;
import com.yixutech.library.entity.User;
import com.yixutech.library.service.IUserService;
import com.yixutech.library.service.exception.PasswordNotMatchException;
import com.yixutech.library.service.exception.UserNotFoundException;
import com.yixutech.library.service.exception.UsernameConflictException;
import com.yixutech.library.util.Validator;




@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/reg.do")
	public String showReg() {
		return "user_reg";
	}

	@RequestMapping("/login.do")
	public String showLogin() {
		return "user_login";
	}
	
	@RequestMapping("/change_password.do")
	public String showChangePassword() {
		return "user_change_password";
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_reg.do",method=RequestMethod.POST)
	public ResponseResult<Void> handleLogin(@RequestParam("username")String username,@RequestParam("password")String password,String salt,String realname,String email,String phone,Integer gender,Date birthday){
		ResponseResult<Void> rr;
		boolean result = Validator.checkUsername(username);
		if (!result) {
			rr = new ResponseResult<Void>(ResponseResult.STATE_ERR, "您输入的用户名格式有误!");
			return rr;
		}
		result = Validator.checkPassword(password);
		if (!result) {
			rr = new ResponseResult<Void>(ResponseResult.STATE_ERR, "您输入的密码格式有误!");
			return rr;
		}
		try {
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			User user = new User(username, password, salt, realname, email, phone, gender, birthday);
			userService.reg(user);
			rr = new ResponseResult<Void>(ResponseResult.STATE_OK);
		} catch (UsernameConflictException e) {
			rr = new ResponseResult<Void>(e);
		} 
		return rr;
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_login.do",method=RequestMethod.POST)
	public ResponseResult<Void> handleLogin(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session){
		ResponseResult<Void> rr;
		try {
			User user = userService.findUserByUsername(username);
			session.setAttribute("id",user.getId());
			session.setAttribute("username", user.getUsername());
			rr = new ResponseResult<Void>(ResponseResult.STATE_OK);
		} catch (UserNotFoundException e) {
			rr = new ResponseResult<Void>(-1, "用户未注册");
		} catch (PasswordNotMatchException e) {
			rr = new ResponseResult<Void>(-2, "密码错误");
		}
		return rr;
	}
	
	
	
	
	
	
	
	
	
	
	
}
