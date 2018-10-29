package com.yixutech.demo.service.exception;

public class PasswordNotMatchException extends ServiceException{

	private static final long serialVersionUID = -7510127512522719855L;

	public PasswordNotMatchException() {
		super();
	}

	public PasswordNotMatchException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PasswordNotMatchException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PasswordNotMatchException(String arg0) {
		super(arg0);
	}

	public PasswordNotMatchException(Throwable arg0) {
		super(arg0);
	}
	
}
