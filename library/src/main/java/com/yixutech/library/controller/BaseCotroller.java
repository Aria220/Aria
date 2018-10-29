package com.yixutech.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseCotroller {
	/**
	 *获取上下文路径
	 * @return
	 */
	protected String getContextPath() {
	    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getContextPath();
	}
	/**
	 * 从session中获取uid
	 * @param session
	 * @return
	 */
	protected final Long getIdFromSession(HttpSession session) {
		return Long.valueOf(session.getAttribute("uid").toString());
	}
}
