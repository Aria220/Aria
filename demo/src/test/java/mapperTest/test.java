package mapperTest;


import org.springframework.util.DigestUtils;

public class test {
	public static void main(String[] args) {
		String password ="123456";
		password = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		System.out.println(password);
	}
	
}
