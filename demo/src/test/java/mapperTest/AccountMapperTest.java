package mapperTest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.demo.entity.Account;
import com.yixutech.demo.mapper.AccountMapper;
import com.yixutech.demo.mapper.UserMapper;



public class AccountMapperTest {
	@Test
	public void testInsert() throws ParseException{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AccountMapper accountMapper = ac.getBean("accountMapper",AccountMapper.class);
		Date now = new Date();
		Account account = new Account("cao","199312",1,"18612345678","xx@xx.com","xx路",2,1,1,"cloud0072",now,"cloud0072",now,"备注");
		Integer row = accountMapper.insert(account);
		System.out.println("row:"+row);
		ac.close();
	}
	@Test
	public void testFindAccountById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AccountMapper accountMapper = ac.getBean("accountMapper",AccountMapper.class);
		Account account = accountMapper.findAccountById(1);
		System.out.println(account);
		ac.close();
	}
	@Test
	public void testGetAccountList(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AccountMapper accountMapper = ac.getBean("accountMapper",AccountMapper.class);
		List<Account> accounts = accountMapper.getAccountList();
		System.out.println(accounts);
		ac.close();
	}
	@Test
	public void testDelete(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		Integer row = userMapper.delete(3,"123");
		System.out.println(row);
		ac.close();
	}
	@Test
	public void testChangeInfo(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AccountMapper accountMapper = ac.getBean("accountMapper",AccountMapper.class);
		Account account = new Account("yang", "199206", 0, "18812345678", "33@xx.com", "xx市", 2, 1, 1, null, null, "concerto1", new Date(), "");
		account.setId(2);
		Integer row = accountMapper.changeInfo(account);
		System.out.println(row);
		ac.close();
	}
	
	
}
