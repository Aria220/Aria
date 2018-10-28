package mapperTest;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.library.entity.RolePermission;

import com.yixutech.library.mapper.RolePermissionMapper;

public class RolePermissionMapperTest {
	@Test
	public void testInsert() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		RolePermissionMapper rolePermissionMapper = ac.getBean("rolePermissionMapper", RolePermissionMapper.class);
		RolePermission rolePermission = new RolePermission(1L, 1L);
		Integer row = rolePermissionMapper.insert(rolePermission);
		System.out.println("row:" + row);
		ac.close();
	}
}
