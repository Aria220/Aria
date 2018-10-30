package serviceTest;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.demo.entity.CurriculumVitae;
import com.yixutech.demo.mapper.CurriculumVitaeMapper;
import com.yixutech.demo.service.ICurriculumVitaeService;

public class curriculumVitaeServiceTest {
	@Test
	public void testFindCurriculumVitaeByAccountId() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		//CurriculumVitaeMapper curriculumVitaeMapper = ac.getBean("curriculumVitaeMapper",CurriculumVitaeMapper.class);
		ICurriculumVitaeService curriculumVitaeService = ac.getBean("curriculumVitaeService",ICurriculumVitaeService.class);
		List<CurriculumVitae> curriculumVitaes = curriculumVitaeService.getCurriculumVitaeListByAccountId(1);
		System.out.println(curriculumVitaes);
		ac.close();
	}
}
