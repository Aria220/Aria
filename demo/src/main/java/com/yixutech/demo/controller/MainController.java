package com.yixutech.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yixutech.demo.entity.Account;
import com.yixutech.demo.entity.CurriculumVitae;
import com.yixutech.demo.entity.User;
import com.yixutech.demo.service.IAccountService;
import com.yixutech.demo.service.ICurriculumVitaeService;
import com.yixutech.demo.service.IUserService;

@Controller
@RequestMapping("/main")
public class MainController extends BaseController{
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping("/index")
	public String showIndex(ModelMap modelMap,HttpSession session) {
		Integer uid = getUidFromSession(session);
		System.out.println(uid);
		User user = userService.findUserById(uid);
		System.out.println(user);
		Integer accountId = user.getAccountId();
		System.out.println(accountId);
		List<CurriculumVitae> curriculumVitaes = curriculumVitaeService.getCurriculumVitaeListByAccountId(accountId);
		System.out.println(curriculumVitaes);
		Account account = accountService.findAccountById(accountId);
		System.out.println(account);
		modelMap.addAttribute("user",user);
		modelMap.addAttribute("curriculumVitaes",curriculumVitaes);
		modelMap.addAttribute("account",account);
		return "index";
	}
	
	@RequestMapping("/admin_index")
	public String showAdminIndex(ModelMap modelMap,HttpSession session) {
		List<Account> accounts = accountService.getAccountList();
		modelMap.addAttribute("accounts",accounts);
		return "admin_index";
	}
	
}
