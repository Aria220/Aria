package com.yixutech.library.mapper;

import java.util.List;

import com.yixutech.library.entity.Book;

public interface BookMapper {
	/**
	 * 增加书本状态信息
	 * @param role
	 * @return
	 */
	Integer insert(Book book);
	/**
	 * 根据id查找书本信息
	 * @param id
	 * @return
	 */
	Book findBookById(Long id);
	/**
	 * 查找所有书本信息
	 * @return
	 */
	List<Book> getBookList();
	
	
}
