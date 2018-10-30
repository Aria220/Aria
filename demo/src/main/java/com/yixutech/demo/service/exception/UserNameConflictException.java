package com.yixutech.demo.service.exception;

public class UserNameConflictException extends ServiceException{

	private static final long serialVersionUID = -4643050742669417608L;

	public UserNameConflictException() {
		super();
	}

	public UserNameConflictException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserNameConflictException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserNameConflictException(String arg0) {
		super(arg0);
	}

	public UserNameConflictException(Throwable arg0) {
		super(arg0);
	}
	
}
