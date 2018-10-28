package com.yixutech.library.mapper;

import com.yixutech.library.entity.Borrow;

public interface BorrowMapper {
	/**
	 * 增加书本状态信息
	 * @param role
	 * @return
	 */
	Integer insert(Borrow borrow);
}
