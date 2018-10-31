package com.yixutech.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yixutech.demo.entity.CurriculumVitae;
import com.yixutech.demo.entity.User;
import com.yixutech.demo.service.ICurriculumVitaeService;
import com.yixutech.demo.service.IUserService;

@Controller
@RequestMapping("/curr")
public class CurriculumVitaeController {
	
	@Autowired
	private ICurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/add_info")
	public String showReg() {
		return "user_add_curr";
	}
	
	@RequestMapping(value= "/add_curr",method=RequestMethod.POST)
	public String handleAddInfo(String company,String department,String position,String hireDate,String leaveDate,HttpSession session) throws ParseException {
		System.out.println("hireDate:"+hireDate+"levaeDate:"+leaveDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hTime = sdf.parse(hireDate);
		Date lTime = sdf.parse(leaveDate);
		Integer accountId = Integer.valueOf(session.getAttribute("accountId").toString());
		String userName = session.getAttribute("userName").toString();
		User user = userService.findUserByUserName(userName);
		Date now = new Date();
		CurriculumVitae curriculumVitae =  new CurriculumVitae(accountId, company, department, position, hTime, lTime, 1, userName, now, userName, now, "备注");
		curriculumVitaeService.insert(curriculumVitae);
		return "redirect:../main/index";
		
	}
}
