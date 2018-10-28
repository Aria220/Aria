package mapperTest;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.library.entity.UserRole;
import com.yixutech.library.mapper.UserRoleMapper;


public class UserRoleMapperTest {
	@Test
	public void testInsert() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserRoleMapper userRoleMapper = ac.getBean("userRoleMapper",UserRoleMapper.class);
		UserRole userRole = new UserRole(1L,1L);
		Integer row = userRoleMapper.insert(userRole);
		System.out.println("row:"+row);
		ac.close();
	}
}
