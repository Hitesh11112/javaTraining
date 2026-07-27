package com.coforge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Account;

@Repository
public class AccountDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Account> getAllAccount() {
		String query = "select * from account";
		return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Account.class));
	}

	public int addAccount(Account account) {
		String query = "insert into account (acc_no, acc_holder_name, bank_name, address, balance) values (?,?,?,?,?)";
		return jdbcTemplate.update(query,
				account.getAccNo(),
				account.getAccHolderName(),
				account.getBankName(),
				account.getAddress(),
				account.getBalance());
	}

	public Account getAccountByno(long accNo) {
		String query = "select * from account where acc_no=?";
		List<Account> accounts = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Account.class),accNo);
		
		if(accounts != null) {
			return accounts.get(0);
		}
		return null;
	}
	
	public int updateAccount(Account ac) {
		String query = "update account set acc_holder_name=?, bank_name=?, address=?, balance=? where acc_no=?";
		return jdbcTemplate.update(query,
				ac.getAccHolderName(),
				ac.getBankName(),
				ac.getAddress(),
				ac.getBalance(),
				ac.getAccNo());
	}
	
	public int deleteAccount(long accNo) {
		String query = "delete from account where acc_no=?";
		return jdbcTemplate.update(query,accNo);
	}
	
}
