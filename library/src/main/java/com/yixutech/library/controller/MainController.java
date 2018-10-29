package com.yixutech.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yixutech.library.entity.User;
import com.yixutech.library.service.IUserService;

@Controller
@RequestMapping("/main")
public class MainController extends BaseCotroller{
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/index")
	public String showIndex(HttpSession session,ModelMap modelMap) {
		Long uid = getIdFromSession(session);
		User user = userService.findUserById(uid);
		modelMap.addAttribute("user",user);
		return "index";
	}
	
	
	
}
