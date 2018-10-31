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

import com.yixutech.demo.entity.Administrator;
import com.yixutech.demo.entity.User;
import com.yixutech.demo.service.IAdministratorService;
import com.yixutech.demo.service.exception.PasswordNotMatchException;
import com.yixutech.demo.service.exception.UserNotFoundException;

//import com.yixutech.demo.service.IAdministratorService;

@Controller
@RequestMapping("/admin")
public class AdministratorController extends BaseController{
	
	@Autowired
	private IAdministratorService administratorService;
	
	@RequestMapping("/reg")
	public String showReg() {
		return "admin_reg";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "admin_login";
	}
	
	@RequestMapping("/change_password")
	public String showChangePassword() {
		return "user_change_password";
	}
	
	@ResponseBody
	@RequestMapping(value="/handle_login",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> handleLogin(@RequestParam("userName") String userName,@RequestParam("password") String password, HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Administrator administrator = administratorService.findAdministratorByUserName(userName);
			session.setAttribute("adminId",administrator.getId());
			session.setAttribute("adminUserName",administrator.getUserName());
			String path = getContextPath();
			map.put("message", "登录成功");
			map.put("url", path+"/main/admin_index");
		} catch (UserNotFoundException e) {
			map.put("message", "管理员不存在");
		} catch (PasswordNotMatchException e) {
			map.put("message", "密码错误");
		}
		return ResponseEntity.ok(map);
	}
}
