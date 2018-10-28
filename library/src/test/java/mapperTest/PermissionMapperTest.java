package mapperTest;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.library.entity.Permission;
import com.yixutech.library.mapper.PermissionMapper;


public class PermissionMapperTest {
	@Test
	public void testInsert() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		PermissionMapper PermissionMapper = ac.getBean("permissionMapper",PermissionMapper.class);
		Permission permission = new Permission("1","删除","删除数据");
		Integer row = PermissionMapper.insert(permission);
		System.out.println("row:"+row);
		ac.close();
	}
}
