package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.exception.InsufficientBalanceException;
import com.hsbc.model.beans.Account;
import com.hsbc.model.service.AccountService;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class MainViewController {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		AccountService service=(AccountService) UserFactory.getInstance(Type.SERVICE);
		int option=0;
		do {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Enter any of the following options");
			System.out.println("1.Store Account");
			System.out.println("2.Fetch All Account");
			System.out.println("3.Fetch Account By Id");
			System.out.println("4.Transfer Amount");
			System.out.println("5.Exit");
			System.out.println("-------------------------------------------------------------------------------");
			option=scanner.nextInt();
			switch (option) {
				case 1:
					Account account=new Account();
					System.out.println("Please enter your name : ");
					String name=scanner.next();
					System.out.println("Please enter balance : ");
					double balance=scanner.nextDouble();
					System.out.println("Please enter phone number : ");
					long phoneNumber=scanner.nextLong();
					account.setCustomerName(name);
					account.setBalance(balance);
					account.setContactNumber(phoneNumber);
					Account createdAccount=service.createAccount(account);
					System.out.println("Account created with account number : "+createdAccount.getAccountNumber());
					break;
				case 2:
					Account[] allAccounts=service.getAllAccounts();
					for(Account temp:allAccounts) {
						if(temp!=null)
							System.out.println(temp);
					}
					break;
				case 3:
					System.out.println("Enter the account Number you want to search : ");
					int accountSearch=scanner.nextInt();
					try {
						Account accountSearchId=service.getAccountById(accountSearch);
						System.out.println(accountSearchId);
					}catch(AccountNotFoundException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 4:
					try {
					System.out.println("Enter the Source Account Number : ");
					int sourceAccount=scanner.nextInt();
					System.out.println("Enter the Destination Account Number : ");
					int DestinationAccount=scanner.nextInt();
					System.out.println("Enter the amount to transfer : ");
					double amount=scanner.nextDouble();
					service.transfer(sourceAccount, DestinationAccount,amount);
					}catch(AccountNotFoundException e) {
						System.err.println(e.getMessage());
					}catch(InsufficientBalanceException e) {
						System.err.println(e.getMessage());
					}
			}
		}while(option!=5);
		scanner.close();
	}

}
