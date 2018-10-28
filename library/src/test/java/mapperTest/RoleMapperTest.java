package mapperTest;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.library.entity.Role;
import com.yixutech.library.mapper.RoleMapper;


public class RoleMapperTest {
	@Test
	public void testInsert() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		RoleMapper roleMapper = ac.getBean("roleMapper",RoleMapper.class);
		Role role = new Role("1","管理员","管理");
		Integer row = roleMapper.insert(role);
		System.out.println("row:"+row);
		ac.close();
	}
}
