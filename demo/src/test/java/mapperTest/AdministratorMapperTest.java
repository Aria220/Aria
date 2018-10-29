package mapperTest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.demo.entity.Administrator;

import com.yixutech.demo.mapper.AdministratorMapper;




public class AdministratorMapperTest {
	@Test
	public void testInsert() throws ParseException{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AdministratorMapper administratorMapper = ac.getBean("administratorMapper",AdministratorMapper.class);
		
		Date now = new Date();
		Administrator administrator = new Administrator("concerto", "123456", 1, 0, "concerto", now, "concerto", now, "备注");
		Integer row = administratorMapper.insert(administrator);
		System.out.println("row:"+row);
		ac.close();
	}
	@Test
	public void testFindUserById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AdministratorMapper administratorMapper = ac.getBean("administratorMapper",AdministratorMapper.class);
		Administrator administrator = administratorMapper.findAdministratorById(1);
		System.out.println(administrator);
		ac.close();
	}
	@Test
	public void testGetAdministratorList(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AdministratorMapper AdministratorMapper = ac.getBean("administratorMapper",AdministratorMapper.class);
		List<Administrator> Administrators = AdministratorMapper.getAdministratorList();
		System.out.println(Administrators);
		ac.close();
	}
	@Test
	public void testDelete(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AdministratorMapper administratorMapper = ac.getBean("administratorMapper",AdministratorMapper.class);		
		Integer row = administratorMapper.delete(2);
		System.out.println(row);
		ac.close();
	}
	
	
}
