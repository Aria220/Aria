package com.yixutech.library.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseCotroller {
	protected String getContextPath() {
	    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getContextPath();
	}
}
