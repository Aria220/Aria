package com.yixutech.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")

public class MainController {
	
	@RequestMapping("/index")
	public String showReg() {
		return "index";
	}
	
}
