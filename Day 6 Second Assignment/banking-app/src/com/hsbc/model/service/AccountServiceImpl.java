package com.hsbc.model.service;

import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.exception.InsufficientBalanceException;
import com.hsbc.model.beans.Account;
import com.hsbc.model.dao.AccountDao;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class AccountServiceImpl implements AccountService{

	private AccountDao dao;
	
	public AccountServiceImpl() {
		dao=(AccountDao) UserFactory.getInstance(Type.DAO);
	}

	@Override
	public Account createAccount(Account account) {
		Account user=dao.store(account);
		return user;
	}
	
	@Override
	public Account[] getAllAccounts() {
		return dao.fetchAccounts();
	}

	@Override
	public Account getAccountById(int accountNumber) throws AccountNotFoundException {
		Account userSearch=dao.fetchAccountById(accountNumber);
		if(userSearch==null)
			throw new AccountNotFoundException("Account with Account Number "+accountNumber+" not found.");
		return userSearch;
	}

	@Override
	public void transfer(int from, int to, double amount)
			throws AccountNotFoundException, InsufficientBalanceException {
		
		Account fromAccount=dao.fetchAccountById(from);
		if(fromAccount==null)
			throw new AccountNotFoundException("Source Account number "+from+" not found");
		Account toAccount=dao.fetchAccountById(to);
		if(toAccount==null)
			throw new AccountNotFoundException("Destination Account number "+from+" not found");
		double presentAmountSource=fromAccount.getBalance();
		if(presentAmountSource<amount)
			throw new InsufficientBalanceException("Balance not sufficient in source account to transfer.Present balance is "+presentAmountSource);
		presentAmountSource-=amount;
		double presentAmountDestination=toAccount.getBalance();
		presentAmountDestination+=amount;
		fromAccount.setBalance(presentAmountSource);
		toAccount.setBalance(presentAmountDestination);
		System.out.println("Destination Account updated Balance : "+presentAmountSource);
		System.out.println("Source Account updated Balance : "+presentAmountDestination);
		dao.updateAccount(from, fromAccount);
		dao.updateAccount(to,toAccount);
	}


}
