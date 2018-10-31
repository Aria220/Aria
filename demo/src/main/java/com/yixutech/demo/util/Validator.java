package com.yixutech.demo.util;

/**
 * 验证器,用于验证字符串的格式是否正确
 * @author soft01
 *
 */
public final class Validator {

	public static final String REGEX_USERNAME = "^[A-Za-z]{1}[A-Za-z0-9_]{5,15}$";
	public static final String REGEX_PASSWORD = "^[A-Z][A-Za-z0-9]{6,18}$";
	public static final String REGEX_PHONE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	public static final String REGEX_IDNUMBER = "^[1-8][0-7]{2}\\\\d{3}([12]\\\\d{3})(0[1-9]|1[012])(0[1-9]|[12]\\\\d|3[01])\\\\d{3}([0-9Xx])$";
	
	private Validator() {
		super();
	}	
	/**
	 * 验证用户名
	 * @param username 需要被验证格式的用户名
	 * @return 如果符合格式要求,则返回true,否则返回false
	 */
	public static boolean checkUsername(String username) {		
		return username.matches(REGEX_USERNAME);
	}
	/**
	 * 验证密码
	 * @param password
	 * @return 如果符合格式要求,则返回true,否则返回false
	 */
	public static boolean checkPassword(String password) {		
		return password.matches(REGEX_PASSWORD);
	}
	/**
	 * 验证电话号码
	 * @param phone
	 * @return 如果符合格式要求,则返回true,否则返回false
	 */
	public static boolean checkPhone(String phone) {		
		return phone.matches(REGEX_PHONE);
	}
	/**
	 * 验证电子邮箱
	 * @param email
	 * @return 如果符合格式要求,则返回true,否则返回false
	 */
	public static boolean checkEmail(String email) {		
		return email.matches(REGEX_EMAIL);
	}
	/**
	 * 验证身份证号
	 * @param idNumber
	 * @return 如果符合格式要求,则返回true,否则返回false
	 */
	public static boolean checkIdNumber(String idNumber) {		
		return idNumber.matches(REGEX_IDNUMBER);
	}
	
}
