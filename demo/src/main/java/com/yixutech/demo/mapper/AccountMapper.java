package com.yixutech.demo.mapper;

import java.util.List;

import com.yixutech.demo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
	
	Integer insert(Account account);
	
	Account findAccountById(Integer id);
	
	List<Account> getAccountList();
	
	Integer delete(Integer id);
	
	Integer changeInfo(Account account);
}
