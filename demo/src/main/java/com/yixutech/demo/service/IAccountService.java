package com.yixutech.demo.service;

import java.util.List;

import com.yixutech.demo.entity.Account;

public interface IAccountService {
	Integer insert(Account account);
	
	Account findAccountById(Integer id);
	
	List<Account> getAccountList();
	
	Integer delete(Integer id);
}
