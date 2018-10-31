package com.yixutech.demo.service.exception;

public class VerificationCodeNotMatchException extends ServiceException{

	private static final long serialVersionUID = -1626663991660279024L;

	public VerificationCodeNotMatchException() {
		super();
	}

	public VerificationCodeNotMatchException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public VerificationCodeNotMatchException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public VerificationCodeNotMatchException(String arg0) {
		super(arg0);
	}

	public VerificationCodeNotMatchException(Throwable arg0) {
		super(arg0);
	}
	
}
