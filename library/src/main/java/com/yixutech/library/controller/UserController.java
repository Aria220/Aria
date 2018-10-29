package com.yixutech.library.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
	
	@RequestMapping("/change_info")
	public String showChangeInfo() {
		return "user_change_info";
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_reg",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleReg(@RequestParam("username")String username,@RequestParam("password")String password,String salt,String realname,String email,String phone,Integer gender,String birthday,HttpSession session) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean result = Validator.checkUsername(username);
		if (!result) {
			map.put("message", "您输入的用户名格式有误!");
			return ResponseEntity.ok(map);
		}
		result = Validator.checkPassword(password);
		if (!result) {
			map.put("message",  "您输入的密码格式有误!");
			return ResponseEntity.ok(map);
		}
		try {
			System.out.println(birthday);
			Date birth = sdf.parse(birthday);
			User user = new User(username, password, salt, realname, email, phone, gender, birth);
			userService.reg(user);
			session.setAttribute("uid",user.getId());
			session.setAttribute("username", user.getUsername());
			String path = getContextPath();		
			map.put("message",  "注册成功!");
			map.put("url", path+"/main/index");
		} catch (UsernameConflictException e) {
			map.put("message",  "注册失败,用户名已存在!");
		} catch (ParseException e) {
			map.put("message",  "日期错误!");
		} 
		
		return ResponseEntity.ok(map);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_login",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleLogin(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			User user = userService.login(username, password);
			session.setAttribute("uid",user.getId());
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
	
	private final String pattern = "yyyy-MM-dd";
	private final SimpleDateFormat sdf = new SimpleDateFormat(pattern,Locale.CHINA);
//	private String getDateString(Date date) {
//		return sdf.format(date);
//	}
	
	
	
	
	
	
	
	
	
}
