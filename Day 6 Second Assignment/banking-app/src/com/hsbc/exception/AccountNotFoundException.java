package com.hsbc.exception;

public class AccountNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super("Account does not exist");
	}
	
	public AccountNotFoundException(String msg) {
		super(msg);
	}
}
