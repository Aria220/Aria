package com.yixutech.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class BaseController {
	protected HttpServletRequest getRequest() {
	    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
	    		.getRequest();
	}
	protected String getContextPath() {
	    return getRequest().getContextPath();
	}
	protected final Integer getIdFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
}
