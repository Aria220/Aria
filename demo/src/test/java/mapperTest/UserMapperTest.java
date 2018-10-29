package mapperTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.demo.entity.User;
import com.yixutech.demo.mapper.UserMapper;
import com.yixutech.demo.service.IUserService;



public class UserMapperTest {
	@Test
	public void testInsert() throws ParseException{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		IUserService userService = ac.getBean("userService",IUserService.class);
		String password = "123456";
		String pwd = userService.getEncryptedPassword(password);
		Date now = new Date();
		User user = new User("cloudoo72","123456",1,1,1,"cloud0072",now,"cloud0072",now,"备注");
		Integer row = userMapper.insert(user);
		System.out.println("row:"+row);
		ac.close();
	}
	@Test
	public void testFindUserByUsername(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		User user = userMapper.findUserByUsername("fire");
		System.out.println(user);
		ac.close();
	}
	@Test
	public void testFindUserById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		User user = userMapper.findUserById(3L);
		System.out.println(user);
		ac.close();
	}
	@Test
	public void testFindAllUser(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		List<User> users = userMapper.findAllUsers();
		System.out.println(users);
		ac.close();
	}
	@Test
	public void testChangePassword(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		Integer row = userMapper.changePassword(1L, "123456");
		System.out.println(row);
		ac.close();
	}
	@Test
	public void testDelete(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		Integer row = userMapper.delete(3L, "1");
		System.out.println(row);
		ac.close();
	}
	
	
}
