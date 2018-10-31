package com.yixutech.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yixutech.demo.entity.Account;
import com.yixutech.demo.service.IAccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping("/change_info")
	public String handleChangeInfo(Account account,HttpSession session) {
		
		System.out.println("account1:"+account);
		String userName = session.getAttribute("userName").toString();
		Integer accountId = Integer.parseInt(session.getAttribute("accountId").toString());
		Date now = new Date();
		account.setId(accountId);
		account.setUpdateTime(now);
		account.setUpdateUser(userName);
		System.out.println("account2:"+account);
		accountService.changeInfo(account);
		return "redirect:/main/index";
		
	}
}
