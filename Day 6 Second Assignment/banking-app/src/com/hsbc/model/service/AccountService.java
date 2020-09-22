package com.hsbc.model.service;

import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.exception.InsufficientBalanceException;
import com.hsbc.model.beans.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public Account[] getAllAccounts();
	public Account getAccountById(int accountNumber) throws AccountNotFoundException;
	public void transfer(int from,int to,double amount) throws AccountNotFoundException,InsufficientBalanceException;
}
