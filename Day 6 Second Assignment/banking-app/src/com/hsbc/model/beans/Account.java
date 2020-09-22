package com.hsbc.model.beans;

public class Account {
	private int accountNumber;
	private String customerName;
	private double balance;
	private long contactNumber;
	
	private static int accountCounter=1;

	public Account() {
		super();
		this.accountNumber=accountCounter++;
	}
	
	

	public int getAccountNumber() {
		return accountNumber;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerName=" + customerName + ", balance=" + balance
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	
	
	
}
