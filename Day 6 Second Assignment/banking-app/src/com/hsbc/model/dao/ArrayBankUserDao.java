package com.hsbc.model.dao;

import com.hsbc.model.beans.Account;

public class ArrayBankUserDao implements AccountDao{

	private static Account[] accountUser=new Account[10];
	
	private static int index=0; 
	
	@Override
	public Account store(Account account) {
		accountUser[index++]=account;
		return account;
	}

	@Override
	public Account[] fetchAccounts() {
		return accountUser;
	}

	@Override
	public Account fetchAccountById(int accountNumber) {
		Account user=null;
		for(int i=0;i<index;i++) {
			if(accountUser[i].getAccountNumber()==accountNumber) {
				user=accountUser[i];
				break;
			}
		}
		return user;
	}

	@Override
	public Account updateAccount(int accountNumber, Account account) {
		for(int i=0;i<index;i++) {
			if(accountUser[i].getAccountNumber()==accountNumber) {
				accountUser[i]=account;
				break;
			}
		}
		return account;
	}
}
