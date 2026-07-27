package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.dao.AccountDao;
import com.coforge.entities.Account;

@Service
public class AccountService {
	
	@Autowired
	AccountDao dao;
	
	public List<Account> getAllAccount() {
		return dao.getAllAccount();
	}
	public int addAccount(Account account) {
		return dao.addAccount(account);
	}
	public Account getAccountByNo(long accNo) {
		return dao.getAccountByno(accNo);
	}
	public int updateAccount(Account account) {
		return dao.updateAccount(account);
	}
	public int deleteAccount(long accNo) {
		return dao.deleteAccount(accNo);
	}
	
}
