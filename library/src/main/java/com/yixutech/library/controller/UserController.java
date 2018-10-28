package com.yixutech.library.controller;

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

import com.mysql.fabric.Response;
import com.yixutech.library.entity.ResponseResult;
import com.yixutech.library.entity.User;
import com.yixutech.library.service.IUserService;
import com.yixutech.library.service.exception.PasswordNotMatchException;
import com.yixutech.library.service.exception.UserNotFoundException;
import com.yixutech.library.service.exception.UsernameConflictException;
import com.yixutech.library.util.Validator;




@Controller
@RequestMapping("/user")
public class UserController extends BaseCotroller{
	
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
	
//	@ResponseBody
//	@RequestMapping(value="/handle_login",method=RequestMethod.POST)
//	public ResponseResult<Void> handleLogin(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session){
//		ResponseResult<Void> rr;
//		try {
//			User user = userService.login(username, password);
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
	@RequestMapping(value="/handle_login",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handLogin(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			User user = userService.login(username, password);
			session.setAttribute("id",user.getId());
			session.setAttribute("username", user.getUsername());	
			String path = getContextPath();
			System.out.println(path);
			map.put("message", "登录成功");
			map.put("url",path+"/main/index");
		} catch (UserNotFoundException e) {
			map.put("message", "用户不存在");
		} catch (PasswordNotMatchException e) {
			map.put("message", "密码错误");
		}
		return ResponseEntity.ok(map);
	}
	
	
	
	
	
	
	
	
	
	
	
}
