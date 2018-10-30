package mapperTest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.demo.entity.Account;
import com.yixutech.demo.entity.CurriculumVitae;
import com.yixutech.demo.mapper.AccountMapper;
import com.yixutech.demo.mapper.CurriculumVitaeMapper;
import com.yixutech.demo.mapper.UserMapper;



public class CurriculumVitaeMapperTest {
	@Test
	public void testInsert() throws ParseException{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		CurriculumVitaeMapper curriculumVitaeMapper = ac.getBean("curriculumVitaeMapper",CurriculumVitaeMapper.class);
		Date now = new Date();
		CurriculumVitae curriculumVitae = new CurriculumVitae(1, "yixu", "软件部", "java开发", now, now, 1, "cloud0072", now, "cloud0072", now, "信息");
		Integer row = curriculumVitaeMapper.insert(curriculumVitae);
		System.out.println("row:"+row);
		ac.close();
	}
	@Test
	public void testFindUserById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CurriculumVitaeMapper curriculumVitaeMapper = ac.getBean("curriculumVitaeMapper",CurriculumVitaeMapper.class);
		CurriculumVitae curriculumVitae = curriculumVitaeMapper.findCurriculumVitaeById(1);
		System.out.println(curriculumVitae);
		ac.close();
	}
	@Test
	public void testGetCurriculumVitaeList(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CurriculumVitaeMapper curriculumVitaeMapper = ac.getBean("curriculumVitaeMapper",CurriculumVitaeMapper.class);
		List<CurriculumVitae> curriculumVitaes = curriculumVitaeMapper.getCurriculumVitaeList();
		System.out.println(curriculumVitaes);
		ac.close();
	}
	@Test
	public void testGetCurriculumVitaeListByAccountId(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CurriculumVitaeMapper curriculumVitaeMapper = ac.getBean("curriculumVitaeMapper",CurriculumVitaeMapper.class);
		List<CurriculumVitae> curriculumVitaes = curriculumVitaeMapper.getCurriculumVitaeListByAccountId(1);
		System.out.println(curriculumVitaes);
		ac.close();
	}
	@Test
	public void testDelete(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CurriculumVitaeMapper curriculumVitaeMapper = ac.getBean("curriculumVitaeMapper",CurriculumVitaeMapper.class);		
		Integer row = curriculumVitaeMapper.delete(2);
		System.out.println(row);
		ac.close();
	}
	
	
}
