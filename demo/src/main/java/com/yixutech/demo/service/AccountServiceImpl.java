package com.yixutech.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yixutech.demo.entity.Account;
import com.yixutech.demo.mapper.AccountMapper;

@Service("accountService")
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Integer insert(Account account) {
		return accountMapper.insert(account);
	}

	@Override
	public Account findAccountById(Integer id) {	
		return accountMapper.findAccountById(id);
	}

	@Override
	public List<Account> getAccountList() {
		return accountMapper.getAccountList();
	}

	@Override
	public Integer delete(Integer id) {
		return accountMapper.delete(id);
	}

	@Override
	public Integer changeInfo(Account account) {
		return accountMapper.changeInfo(account);
	}
	
}
