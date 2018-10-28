package mapperTest;


import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yixutech.library.entity.Book;
import com.yixutech.library.mapper.BookMapper;


public class BookMapperTest {
	@Test
	public void testInsert() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		BookMapper bookMapper = ac.getBean("bookMapper",BookMapper.class);
		Book book = new Book("西游记","吴承恩",8,78);
		Integer row = bookMapper.insert(book);
		System.out.println("row:"+row);
		ac.close();
	}
	@Test
	public void testFindBookById() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		BookMapper bookMapper = ac.getBean("bookMapper",BookMapper.class);
		Book book =bookMapper.findBookById(1L);
		System.out.println(book);
		ac.close();
	}
	@Test
	public void testGetBookList() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		BookMapper bookMapper = ac.getBean("bookMapper",BookMapper.class);
		List<Book> books = bookMapper.getBookList();
		System.out.println(books);
		ac.close();
	}
	
	
}
